package com.tech.app.ws.exceptions;

public class UserServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7290661652681034240L;
    
	public UserServiceException(String message) {
		super(message);
	}
}
