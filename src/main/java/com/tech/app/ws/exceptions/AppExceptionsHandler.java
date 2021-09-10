package com.tech.app.ws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tech.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request) {
		
		String errorMessageDescription = e.getLocalizedMessage();
		
		if (errorMessageDescription==null) errorMessageDescription = e.toString();
		
		ErrorMessage errorMessage  = new ErrorMessage(new Date(),errorMessageDescription);
		
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value= {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerException(NullPointerException e, WebRequest request) {
		
		String errorMessageDescription = e.getLocalizedMessage();
		
		if (errorMessageDescription==null) errorMessageDescription = e.toString();
		
		ErrorMessage errorMessage  = new ErrorMessage(new Date(),errorMessageDescription);
		
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	@ExceptionHandler(value= {UserServiceException.class})
	public ResponseEntity<Object> handleUserServiceException(UserServiceException e, WebRequest request) {
		
		String errorMessageDescription = e.getLocalizedMessage();
		
		if (errorMessageDescription==null) errorMessageDescription = e.toString();
		
		ErrorMessage errorMessage  = new ErrorMessage(new Date(),errorMessageDescription);
		
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

