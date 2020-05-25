package com.info.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class CustomJobExecutionListener implements JobExecutionListener{

	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		//CustomItemWriterListener.fileName=fileName;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		
		
	}

}
