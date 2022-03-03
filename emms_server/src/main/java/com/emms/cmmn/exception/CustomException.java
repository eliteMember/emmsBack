package com.emms.cmmn.exception;

public class CustomException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5320178397563366766L;

	CustomException() {

    }

    public CustomException(String message) {
        super(message);
    }
	
}