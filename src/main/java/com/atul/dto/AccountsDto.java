package com.atul.dto;

import java.io.Serializable;

public class AccountsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1098734908660642979L;	
	private Long accountId;
	private Double balance;
	private String accountType;
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public AccountsDto(Long accountId, Double balance, String accountType) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.accountType = accountType;
	}
	
	
	
	
	
	
}
