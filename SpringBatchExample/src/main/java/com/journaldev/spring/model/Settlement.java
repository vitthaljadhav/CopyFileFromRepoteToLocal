package com.journaldev.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SETTLEMENT")
public class Settlement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int Id;
	
	@Column(name = "BATCH_NAME")
	private String batchName;
	
	@Column(name = "DATE_OF_MONTHS")
	private String date;
	
	@Column(name = "DAY_OF_TIME")
	private String time;
	
	@Column(name = "CARD_NUMBER")
	private String cardNo;
	
	@Column(name = "RRN")
	private String rrn;
	
	@Column(name = "TXN_NO")
	private String TxnNo;
	
	@Column(name = "ISSUED_ID")
	private String issuedId;

	@Column(name = "TXN_TYPE")
	private String transactionType;
	
	@Column(name = "PROCESSING_CODE")
	private String processingCode;

	@Column(name = "ENT_MODE")
	private String entMode;

	@Column(name = "REASON_CODE")
	private String reasonCode;
	
	@Column(name = "CN_STP")
	private String cnSTP;

	@Column(name = "RESPONSE_CODE")
	private String responseCode;
	
	@Column(name = "TXN_AMT")
	private String txnAmt;
	
	@Column(name = "SETTLEMENT_AMT")
	private String settlementAmt;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getTxnNo() {
		return TxnNo;
	}

	public void setTxnNo(String txnNo) {
		TxnNo = txnNo;
	}

	public String getIssuedId() {
		return issuedId;
	}

	public void setIssuedId(String issuedId) {
		this.issuedId = issuedId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getProcessingCode() {
		return processingCode;
	}

	public void setProcessingCode(String processingCode) {
		this.processingCode = processingCode;
	}

	public String getEntMode() {
		return entMode;
	}

	public void setEntMode(String entMode) {
		this.entMode = entMode;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getCnSTP() {
		return cnSTP;
	}

	public void setCnSTP(String cnSTP) {
		this.cnSTP = cnSTP;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getTxnAmt() {
		return txnAmt;
	}

	public void setTxnAmt(String txnAmt) {
		this.txnAmt = txnAmt;
	}

	public String getSettlementAmt() {
		return settlementAmt;
	}

	public void setSettlementAmt(String settlementAmt) {
		this.settlementAmt = settlementAmt;
	}

	@Override
	public String toString() {
		return " " + Id + " " + batchName + " " + date + " " + time + " "
				+ cardNo + " " + rrn + "  " + TxnNo + "  " + issuedId + " "
				+ transactionType + "  " + processingCode + "  " + entMode + " "
				+ reasonCode + "  " + cnSTP + " " + responseCode + " " + txnAmt
				+ " " + settlementAmt + " ";
	}
	
}
