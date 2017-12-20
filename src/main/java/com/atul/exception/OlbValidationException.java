package com.atul.exception;

public class OlbValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OlbValidationException(){
		super();
	}
	
	public OlbValidationException(String message){
		super(message);
	}

}
