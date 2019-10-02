package com.Ganges.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product_Details")
public class ProductEntity {
	
	@Id
	private Integer productId;
	private String productName;
	private Double price;
	private String company;
	private String description;
	private Double promotionalDiscount;
	private Boolean isPromotionalDiscountThere;
	private Double gangesDiscount;
	private Boolean isGangesDiscountThere;
	private String productUrl;
	private Double rating;
	private String productDetails;
	
	
	
	public Double getPromotionalDiscount() {
		return promotionalDiscount;
	}
	public void setPromotionalDiscount(Double promotionalDiscount) {
		this.promotionalDiscount = promotionalDiscount;
	}
	public Boolean getIsPromotionalDiscountThere() {
		return isPromotionalDiscountThere;
	}
	public void setIsPromotionalDiscountThere(Boolean isPromotionalDiscountThere) {
		this.isPromotionalDiscountThere = isPromotionalDiscountThere;
	}
	public Double getGangesDiscount() {
		return gangesDiscount;
	}
	public void setGangesDiscount(Double gangesDiscount) {
		this.gangesDiscount = gangesDiscount;
	}
	public Boolean getIsGangesDiscountThere() {
		return isGangesDiscountThere;
	}
	public void setIsGangesDiscountThere(Boolean isGangesDiscountThere) {
		this.isGangesDiscountThere = isGangesDiscountThere;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
