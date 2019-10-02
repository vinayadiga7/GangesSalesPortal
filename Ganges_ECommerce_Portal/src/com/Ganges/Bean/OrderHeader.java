package com.Ganges.Bean;

import java.util.Calendar;
import java.util.Date;

public class OrderHeader {
	
	private Integer orderHeaderId;
	private Integer transactionId;
	private String Status;
	private String orderDate;
	private String DeliveryDate;
	private String shipmentAddress;
	private Double totalAmount;
	private String customerFullName;
	private String customerUsername; //PK
	public Integer getOrderHeaderId() {
		return orderHeaderId;
	}
	public void setOrderHeaderId(Integer orderHeaderId) {
		this.orderHeaderId = orderHeaderId;
	}
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	public String getShipmentAddress() {
		return shipmentAddress;
	}
	public void setShipmentAddress(String shipmentAddress) {
		this.shipmentAddress = shipmentAddress;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getCustomerFullName() {
		return customerFullName;
	}
	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}
	public String getCustomerUsername() {
		return customerUsername;
	}
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}
	

	
}
