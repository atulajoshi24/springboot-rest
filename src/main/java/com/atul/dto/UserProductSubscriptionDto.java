package com.atul.dto;

import java.io.Serializable;

public class UserProductSubscriptionDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3161469357355260718L;

	private Long productId;
	private Long accountId;
	
	private ProductsDto productsDto;
	private AccountsDto accountsDto;
	
	
	public Long getProductId() {
		return productId;
	}
	public ProductsDto getProductsDto() {
		return productsDto;
	}
	public void setProductsDto(ProductsDto productsDto) {
		this.productsDto = productsDto;
	}
	public AccountsDto getAccountsDto() {
		return accountsDto;
	}
	public void setAccountsDto(AccountsDto accountsDto) {
		this.accountsDto = accountsDto;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public UserProductSubscriptionDto(Long productId, Long accountId) {
		super();
		this.productId = productId;
		this.accountId = accountId;
	}
	
	public UserProductSubscriptionDto(ProductsDto productsDto, AccountsDto accountsDto) {
		super();
		this.productsDto = productsDto;
		this.accountsDto = accountsDto;
	}
	
	
}
