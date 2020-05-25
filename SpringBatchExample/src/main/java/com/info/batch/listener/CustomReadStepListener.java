package com.info.batch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

import com.info.batch.processor.SettlementItemProcessor;
import com.info.batch.tasklet.ExampleReadParamTasklet;
import com.journaldev.spring.model.Settlement;

public class CustomReadStepListener implements ItemReadListener<Settlement>,StepExecutionListener{
	
	 public Integer count = 11;
	 Integer line=11;
	@Override
	public void beforeRead() {
		 line=line+1;
		SettlementItemProcessor.k=line;
		//System.out.println(" beforeRead "+line);
		
	}

	@Override
	public void afterRead(Settlement item) {
		//System.out.println("ItemReadListener - afterRead");
		// count++;
		// line=line+1;
		
	}

	@Override
	public void onReadError(Exception ex) {
		System.out.println("ItemReadListener - onReadError"+ex);
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		//stepExecution.getJobExecution().getExecutionContext().put("ITEM_READ_COUNT", count);
		
		System.out.println("This is Actual Item Is:"+count);
		/*
		 * ExampleReadParamTasklet.k=line.toString(); ExecutionContext execContext = new
		 * ExecutionContext(); execContext.put("linesToSkip", line);
		 */
		return null;
	}

	/*
	 * @Override public RepeatStatus execute(StepContribution contribution,
	 * ChunkContext chunkContext) throws Exception {
	 * 
	 * chunkContext.getStepContext().getStepExecution().getJobExecution().
	 * getExecutionContext().put("linesToSkip", Integer.valueOf(line).intValue());
	 * System.out.println("This is a TaskLet" + line); // Always close files. //
	 * bufferedReader.close();
	 * 
	 * 
	 * return RepeatStatus.FINISHED; }
	 */
}
