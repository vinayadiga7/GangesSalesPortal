package com.Ganges.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account_Entity")
public class AccountEntity {
	
	private String accountNumber;
	@Id
	private String cardNumber;
	private String BankName;
	private String CVV;
	private String CardExpiryCard;
	private Double Balance;
	private String UPIId;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getCVV() {
		return CVV;
	}
	public void setCVV(String cVV) {
		CVV = cVV;
	}
	public String getCardExpiryCard() {
		return CardExpiryCard;
	}
	public void setCardExpiryCard(String cardExpiryCard) {
		CardExpiryCard = cardExpiryCard;
	}
	public Double getBalance() {
		return Balance;
	}
	public void setBalance(Double balance) {
		Balance = balance;
	}
	public String getUPIId() {
		return UPIId;
	}
	public void setUPIId(String uPIId) {
		UPIId = uPIId;
	}
	
	
}
