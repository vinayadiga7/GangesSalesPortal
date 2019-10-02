package com.Ganges.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Order_Details")
public class OrderDetailsEntity {

	@Id @GeneratedValue
	private Integer orderDetailsId;
	
	@OneToOne()
	@JoinColumn(name="orderHeaderId")
	private OrderHeaderEntity orderHeader;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="productId")
	private ProductEntity product;
	private Integer quantity;
	private Double totalPrice;
	public Integer getOrderDetailsId() {
		return orderDetailsId;
	}
	public void setOrderDetailsId(Integer orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	public OrderHeaderEntity getOrderHeader() {
		return orderHeader;
	}
	public void setOrderHeader(OrderHeaderEntity orderHeader) {
		this.orderHeader = orderHeader;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
