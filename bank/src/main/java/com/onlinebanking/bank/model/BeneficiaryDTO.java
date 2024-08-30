package com.onlinebanking.bank.model;

import org.springframework.stereotype.Component;

@Component
public class BeneficiaryDTO {
	
	private long bid;
	private String ifsc;
	private long accNumber;
	private String bankName;
	private String bName;
	private long maxLimit;
//	private long customerId;
//	public long getCustomerId() {
//		return customerId;
//	}
//	public void setCustomerId(long customerId) {
//		this.customerId = customerId;
//	}
	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public long getMaxLimit() {
		return maxLimit;
	}
	public void setMaxLimit(long maxLimit) {
		this.maxLimit = maxLimit;
	}
	@Override
	public String toString() {
		return "BeneficiaryDTO [bid=" + bid + ", ifsc=" + ifsc + ", accNumber=" + accNumber + ", bankName=" + bankName
				+ ", bName=" + bName + ", maxLimit=" + maxLimit + "]";
	}
	
	

}
