package com.atul.dto;

import java.io.Serializable;

public class ErrorMessageDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	private String developerMessage;
	
	public ErrorMessageDto(String message, String developerMessage) {
		super();
		this.message = message;
		this.developerMessage = developerMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	
	

}
