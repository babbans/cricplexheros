/**
 * 
 */
package com.aannya.cricplexheros.exception;

import java.io.Serializable;

public class ListNotFoundException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListNotFoundException() {
		super();
	}

	public ListNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ListNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ListNotFoundException(String message) {
		super(message);
	}

	public ListNotFoundException(Throwable cause) {
		super(cause);
	}

	
	
}
