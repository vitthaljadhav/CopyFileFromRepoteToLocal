package com.journaldev.spring.mapper;


import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.journaldev.spring.model.Settlement;

public class SettlementMapper implements FieldSetMapper<Settlement> {

	@Override
	public Settlement mapFieldSet(FieldSet fieldSet) throws BindException {
// 
		try {
			Settlement settlement = new Settlement();
			settlement.setBatchName(fieldSet.readString("batchName"));
			settlement.setDate(fieldSet.readString("date"));
			settlement.setTime(fieldSet.readString("time"));
			settlement.setCardNo(fieldSet.readString("cardNo"));
			settlement.setRrn(fieldSet.readString("rrn"));
			settlement.setTxnNo(fieldSet.readString("TxnNo"));
			settlement.setIssuedId(fieldSet.readString("issuedId"));
			settlement.setTransactionType(fieldSet.readString("transactionType"));
			settlement.setProcessingCode(fieldSet.readString("processingCode"));
			settlement.setEntMode(fieldSet.readString("entMode"));
			//settlement.setReasonCode(fieldSet.readString("reasonCode"));
			settlement.setReasonCode("000");
			settlement.setCnSTP(fieldSet.readString("cnSTP"));
			settlement.setResponseCode(fieldSet.readString("responseCode"));
			
			settlement.setTxnAmt(fieldSet.readString("txnAmt"));
			settlement.setSettlementAmt(fieldSet.readString("settlementAmt"));
			return settlement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
