package com.info.batch.listener;

import org.springframework.batch.core.SkipListener;

import com.journaldev.spring.model.Settlement;

public class CustomSkipListener implements SkipListener<Settlement, Settlement> {

	@Override
	public void onSkipInRead(Throwable t) {
		System.out.println("onSkipInRead Methods()" + t);

	}

	@Override
	public void onSkipInWrite(Settlement item, Throwable t) {
		System.out.println("onSkipInWrite Methods()" + item);

	}

	@Override
	public void onSkipInProcess(Settlement item, Throwable t) {
		System.out.println("onSkipInProcess "+item);
		
		//System.out.println("");
	}

}
