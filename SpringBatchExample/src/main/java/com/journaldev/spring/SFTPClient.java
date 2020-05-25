package com.journaldev.spring;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.info.batch.constant.Constant;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SFTPClient {
	
	
	public static void main(String args[]) throws FileNotFoundException, IOException {
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession(Constant.USER_NAME, Constant.HOSTNAME, Constant.PORT);
			session.setPassword(Constant.PASSWORD);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			config.put("PreferredAuthentications", "publickey,keyboard-interactive,password");

			session.setConfig(config);
			session.connect();

			Channel channel = session.openChannel("sftp");
			channel.connect();
			System.out.println("sftp channel opened and connected.");
			ChannelSftp channelSftp = (ChannelSftp) channel;

			File directory = new File(Constant.REMOTE_PATH);
			File[] fList = directory.listFiles();
			for (File file : fList) {
				if (file.isFile()) {
					String filename = file.getAbsolutePath();
					channelSftp.get(file.getName(), Constant.LOCAL_PATH);
					System.out.println(filename + " transferred to " + Constant.LOCAL_PATH+file.getName());
				}
			}
			
			
		} catch (JSchException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Transfer Process Completed...");
		}
	}
}