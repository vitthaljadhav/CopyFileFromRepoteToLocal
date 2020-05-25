package com.info.batch.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.info.batch.constant.Constant;

public class BatchService {
	public void batchName(String batchName) {

		if (Constant.REPORT_BATCH.equalsIgnoreCase(batchName)) {
			String[] springConfig = { "spring/batch/jobs/job-batch-demo.xml" };
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
			JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
			Job job = (Job) context.getBean("DemoJobXMLWriter");
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.toJobParameters();
			try {

				JobExecution execution = jobLauncher.run(job, jobParameters);
				System.out.println("Exit Status : " + execution.getStatus());

			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Done");
			context.close();

		} else if (Constant.PROJECT_BATCH.equalsIgnoreCase(batchName)) {
			String[] springConfig = { "spring/batch/jobs/job-batch-project.xml" };
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
//			JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncherProject");
			JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
			Job job = (Job) context.getBean("projectBatch");
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.toJobParameters();
			try {
				JobExecution execution = jobLauncher.run(job, jobParameters);
				System.out.println("Exit Status : " + execution.getStatus());

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Done");
			context.close();

		} else if (Constant.SETTLEMENT_BATCH.equalsIgnoreCase(batchName)) {
		//	String[] springConfig = { "spring/batch/jobs/job-batch-settlement.xml" };
		    String[] springConfig = { "spring/batch/jobs/updated-settlement.xml" };
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
//			JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncherProject");
			JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
			Job job = (Job) context.getBean("settlement");
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.toJobParameters();
			try {
				JobExecution execution = jobLauncher.run(job, jobParameters);
				System.out.println("Exit Status : " + execution.getStatus());

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Done");
			context.close();
			
		} else if(Constant.SFTP_BATCH.equalsIgnoreCase(batchName)){
			String[] springConfig = { "spring/batch/jobs/job-batch-sftp.xml" };
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
			JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
			Job job = (Job) context.getBean("sftpjob");
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.toJobParameters();
			try {

				JobExecution execution = jobLauncher.run(job, jobParameters);
				System.out.println("Exit Status : " + execution.getStatus());

			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Done");
			context.close();
			
		}else {
			System.out.println("Invalid Batch Name");
		}
	}

}
