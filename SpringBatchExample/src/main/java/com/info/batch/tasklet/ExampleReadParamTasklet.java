package com.info.batch.tasklet;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;

public class ExampleReadParamTasklet implements Tasklet {

	// @Value("#{jobParameters['fileParam']}")

	// private String fileParam="resources/csv/input/txn-visa1.txt";

	public static String k;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		String line = "11";

		int a = 10;
		//System.out.println("A =" + a);
		/*
		 * //fileParam="csv/input/txn-visa1.txt"; // FileReader reads text files in the
		 * default encoding. FileReader fileReader = new FileReader(fileParam);
		 * 
		 * // Always wrap FileReader in BufferedReader. BufferedReader bufferedReader =
		 * new BufferedReader(fileReader);
		 * 
		 * while((line = bufferedReader.readLine()) != null) { break; }
		 */
		chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put("linesToSkip",
				Integer.valueOf(line).intValue());
		//System.out.println("This is a TaskLet" + line);
		//System.out.println("Increment" + a + 6);
		// Always close files.
		// bufferedReader.close();
		 
		
		return RepeatStatus.FINISHED;
	}

	public void test(StepContribution contribution, ChunkContext chunkContext, String line) {
		chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().put("linesToSkip",
				Integer.valueOf(line).intValue());
	}
}