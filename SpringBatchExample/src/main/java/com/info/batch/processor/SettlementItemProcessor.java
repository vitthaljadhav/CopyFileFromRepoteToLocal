package com.info.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.journaldev.spring.model.Settlement;

public class SettlementItemProcessor implements ItemProcessor<Settlement, Settlement> {

	public static int k=0;
	@Override
	public Settlement process(Settlement item) throws Exception {
		if(item!=null && k%6==0) {
			item.setResponseCode("10");
			return item;
		}else {
			return null;
		}
		
		
	}

}
