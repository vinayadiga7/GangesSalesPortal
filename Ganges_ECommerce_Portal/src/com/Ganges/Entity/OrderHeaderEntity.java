package com.Ganges.Entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Order_Header")
public class OrderHeaderEntity {

	@Id @GeneratedValue
	private Integer OrderHeaderId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private CustomerEntity customer;
	
	@OneToOne()
	@JoinColumn(name="transactionId")
	private TransactionEntity transaction;
	private String status;
	private Calendar orderDate;
	private Calendar deliveryDate;
	private String Address;
	private Double TotalAmont;
	
	public Integer getOrderHeaderId() {
		return OrderHeaderId;
	}
	public void setOrderHeaderId(Integer orderHeaderId) {
		OrderHeaderId = orderHeaderId;
	}
	public CustomerEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	public TransactionEntity getTransaction() {
		return transaction;
	}
	public void setTransaction(TransactionEntity transaction) {
		this.transaction = transaction;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}
	public Calendar getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Calendar deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Double getTotalAmont() {
		return TotalAmont;
	}
	public void setTotalAmont(Double totalAmont) {
		TotalAmont = totalAmont;
	}
	
	
}
