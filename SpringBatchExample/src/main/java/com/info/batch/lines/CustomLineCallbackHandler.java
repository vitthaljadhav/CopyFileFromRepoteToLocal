package com.info.batch.lines;

import org.springframework.batch.item.file.LineCallbackHandler;

public class CustomLineCallbackHandler implements LineCallbackHandler {

	@Override
	public void handleLine(String line) {
		System.out.println("LineCallbackHandler  IS  :" + line);

	}

}
