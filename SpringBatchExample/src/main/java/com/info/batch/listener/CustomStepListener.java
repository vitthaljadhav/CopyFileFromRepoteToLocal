package com.info.batch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class CustomStepListener implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		System.out.println("CustomStepListener in BeforeStep()");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("customStepListener  in afterStep()");
		return null;
	}

}
