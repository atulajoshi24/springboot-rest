package com.atul.dto;

import java.io.Serializable;

public class ProductsDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5444703699807353572L;
	private Long productId;
	private String productName;
	private String description;
	private double minBalance;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	public ProductsDto(Long productId, String productName, String description, double minBalance) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.minBalance = minBalance;
	}
	
	

}
