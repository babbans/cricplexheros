/**
 * 
 */
package com.aannya.cricplexheros.exception;

public class ModelUpdateFailedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModelUpdateFailedException() {
		super();
	}

	public ModelUpdateFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ModelUpdateFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ModelUpdateFailedException(String message) {
		super(message);
	}

	public ModelUpdateFailedException(Throwable cause) {
		super(cause);
	}

	

}
