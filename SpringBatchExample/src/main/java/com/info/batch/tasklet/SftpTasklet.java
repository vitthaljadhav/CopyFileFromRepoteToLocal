package com.info.batch.tasklet;

import java.io.File;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.repeat.RepeatStatus;

import com.info.batch.constant.Constant;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SftpTasklet implements Tasklet {

	private JSch jsch = null;
	private Session session = null;
	private Channel channel = null;
	private ChannelSftp sftpChannel = null;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		try {
			download();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RepeatStatus.FINISHED;
	}

   //Connection
	public void connect() {
		System.out.println("connecting..." + Constant.HOSTNAME);
		try {
			jsch = new JSch();
			session = jsch.getSession(Constant.USER_NAME, Constant.HOSTNAME, Constant.PORT);
			session.setPassword(Constant.PASSWORD);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			config.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
			session.setConfig(config);
			session.connect();
			channel = session.openChannel("sftp");
			channel.connect();
			sftpChannel = (ChannelSftp) channel;
			System.out.println("sftp channel opened and connected.");

		} catch (JSchException e) {
			e.printStackTrace();
		}
	}

	// DisConnection
	public void disconnect() {
		System.out.println("disconnecting...");
		sftpChannel.disconnect();
		channel.disconnect();
		session.disconnect();
	}

	/// Download File From remote System to local System
	public void download() {
		connect();
		System.out.println("Downloading ....");
		try {
			File directory = new File(Constant.REMOTE_PATH);
			File[] fList = directory.listFiles();
			for (File file : fList) {
				if (file.isFile()) {
					String filename = file.getAbsolutePath();
					sftpChannel.get(file.getName(), Constant.LOCAL_PATH);
					System.out.println(filename + " transferred to " + Constant.LOCAL_PATH + file.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		disconnect();
	}

}
