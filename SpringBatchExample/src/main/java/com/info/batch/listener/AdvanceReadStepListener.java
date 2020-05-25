package com.info.batch.listener;

import java.util.List;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.SkipListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

import com.journaldev.spring.model.Settlement;

public class AdvanceReadStepListener implements JobExecutionListener, StepExecutionListener,SkipListener<Settlement, Settlement>,ItemReadListener<Settlement>,ItemProcessListener<Settlement,Settlement>,ItemWriteListener<Settlement>{

	//JobExecutionListener Methods
	@Override
	public void beforeJob(JobExecution jobExecution) {
	System.out.println("before job Completion");
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("After job Completetion");
		
	}

	//Skip Listener Methods
	@Override
	public void onSkipInRead(Throwable t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSkipInWrite(Settlement item, Throwable t) {
	 
		
	}

	@Override
	public void onSkipInProcess(Settlement item, Throwable t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
	System.out.println("ExitStatus");
		return null;
	}


   //ItemReadListener
	
	@Override
	public void beforeRead() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterRead(Settlement item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReadError(Exception ex) {
		// TODO Auto-generated method stub
		
	}
//ItemProcessor
	@Override
	public void beforeProcess(Settlement item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterProcess(Settlement item, Settlement result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProcessError(Settlement item, Exception e) {
		// TODO Auto-generated method stub
		
	}
	
	//ItemWriterListener
	
	@Override
	public void beforeWrite(List items) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void afterWrite(List items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onWriteError(Exception exception, List items) {
		
		
	}

}
