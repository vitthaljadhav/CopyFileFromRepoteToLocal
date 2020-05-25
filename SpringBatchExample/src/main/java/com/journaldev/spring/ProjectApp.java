package com.journaldev.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProjectApp {
	public static void main(String[] args) {

		String[] springConfig = { "spring/batch/jobs/job-batch-project.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
//		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncherProject");
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
	}
}
