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
@Table(name="My_Kart_Details")
public class KartEntity {
	
	@Id @GeneratedValue
	private Integer kartNumber;
	
	@ManyToOne()
	@JoinColumn(name="username")
	private CustomerEntity customer;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="productId")
	private ProductEntity product;

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Integer getKartNumber() {
		return kartNumber;
	}

	public void setKartNumber(Integer kartNumber) {
		this.kartNumber = kartNumber;
	}
	
	
	
}
