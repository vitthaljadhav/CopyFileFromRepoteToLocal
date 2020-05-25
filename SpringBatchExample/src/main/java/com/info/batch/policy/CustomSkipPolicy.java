package com.info.batch.policy;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.file.FlatFileParseException;

public class CustomSkipPolicy implements SkipPolicy {
	@Override
	public boolean shouldSkip(Throwable exception, int skipCount) throws SkipLimitExceededException {
		if (exception instanceof FileNotFoundException) {
			return false;
		} else if (exception instanceof FlatFileParseException && skipCount <= 5) {
			FlatFileParseException ffpe = (FlatFileParseException) exception;
			StringBuilder errorMessage = new StringBuilder();
			errorMessage.append("An error occured while processing the " + ffpe.getLineNumber()
					+ " line of the file. Below was the faulty " + "input.\n");
			errorMessage.append(ffpe.getInput() + "\n");

			return true;
		} else if (exception instanceof FlatFileParseException) {
			return true;
		} else {
			return false;
		}
	}

}
