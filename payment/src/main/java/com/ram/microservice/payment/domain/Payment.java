package com.ram.microservice.payment.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="payment")
public class Payment {

	@Id
	private String paymentId;
	
	private String userId;
	private double amount;
	private long accountNo;
	private LocalDateTime pymntDateTime;
	//bsb
	private String bankCode;
	private String desc;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public LocalDateTime getPymntDateTime() {
		return pymntDateTime;
	}
	public void setPymntDateTime(LocalDateTime pymntDateTime) {
		this.pymntDateTime = pymntDateTime;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPaymentId() {
		return paymentId;
	}
	
}
