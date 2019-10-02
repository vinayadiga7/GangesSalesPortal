package com.Ganges.Entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transaction_Details")
public class TransactionEntity {

	@Id @GeneratedValue
	private Integer transactionId;
	private String fromAccountCardNumber;
	private String toAccountCardNumber;
	private Double amount;
	private String fromCardExpiryDate;
	private String fromCardCVV;
	private String transactionReferenceNumber;
	private Calendar transactionDate;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public String getFromAccountCardNumber() {
		return fromAccountCardNumber;
	}
	public void setFromAccountCardNumber(String fromAccountCardNumber) {
		this.fromAccountCardNumber = fromAccountCardNumber;
	}
	public String getToAccountCardNumber() {
		return toAccountCardNumber;
	}
	public void setToAccountCardNumber(String toAccountCardNumber) {
		this.toAccountCardNumber = toAccountCardNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getFromCardExpiryDate() {
		return fromCardExpiryDate;
	}
	public void setFromCardExpiryDate(String fromCardExpiryDate) {
		this.fromCardExpiryDate = fromCardExpiryDate;
	}
	public String getFromCardCVV() {
		return fromCardCVV;
	}
	public void setFromCardCVV(String fromCardCVV) {
		this.fromCardCVV = fromCardCVV;
	}
	public String getTransactionReferenceNumber() {
		return transactionReferenceNumber;
	}
	public void setTransactionReferenceNumber(String transactionReferenceNumber) {
		this.transactionReferenceNumber = transactionReferenceNumber;
	}
	public Calendar getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Calendar transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	
}
