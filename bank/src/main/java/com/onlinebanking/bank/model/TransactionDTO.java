package com.onlinebanking.bank.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
public class TransactionDTO {
	
	
	private static long transactionId;
	public TransactionDTO() {
		UUID idOne = UUID.randomUUID();
        String str=""+idOne;        
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        transactionId=Integer.parseInt(str);
	}
	private long Tid;
	public long getTid() {
		return Tid;
	}
	public void setTid(long tid) {
		Tid = tid;
	}
	private long accNumber;
	private long targetAccNumber;
	private long creditAmount;
	private long debitAmount;
	private long balance;
	private String transactionType;
	private Date transactionDate;
	private long amount;
	
	public long getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(long creditAmount) {
		this.creditAmount = creditAmount;
	}
	public long getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(long debitAmount) {
		this.debitAmount = debitAmount;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public long getTargetAccNumber() {
		return targetAccNumber;
	}
	public void setTargetAccNumber(long targetAccNumber) {
		this.targetAccNumber = targetAccNumber;
	}
	
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		TransactionDTO.transactionId = transactionId;
	}
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId + ", accNumber=" + accNumber + ", transactionType="
				+ transactionType + ", transactionDate=" + transactionDate + ", amount=" + amount + "]";
	}
	

}
