package com.Ganges.Bean;

import java.util.Date;

public class OrderDetails {
	
	private Integer orderHeaderId;
	private Integer orderDetailsId;
	private Integer productId;
	private String productImageUrl;
	private Integer quantity;
	private Double unitPrice;
	private Double totalPrice;
	private Boolean isPromotionDiscountThere;
	private Double promotionDiscount;
	private Boolean isGangesDiscountThere;
	private Double gangesDiscount;
	
	
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
