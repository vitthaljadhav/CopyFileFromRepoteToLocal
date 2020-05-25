package com.info.batch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class ExampleSkipLineListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
    	System.out.println("new Step Exception Listener");
        stepExecution.getExecutionContext().put("linesToSkip", stepExecution.getJobExecution().getExecutionContext().get("linesToSkip"));
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}