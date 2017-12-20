package com.atul.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.atul.dto.ErrorMessageDto;
import com.atul.exception.OlbValidationException;


@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(OlbValidationException.class)
	public ResponseEntity<Object> handleOlbValidationException(final Exception ex, final WebRequest request){
		
		return handleExceptionInternal(ex, message(ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	
	
	private ErrorMessageDto message(final Exception ex) {
	        
			final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage();
	        final String devMessage = ex.getClass().getSimpleName();

	        return new ErrorMessageDto(message,devMessage);
	}

}
