package com.soft.quality.if_yes_if_no_teste.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ObjectNotFoundException(String message) {
		super(message);
	
	}
	
	

}
