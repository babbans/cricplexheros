/**
 * 
 */
package com.aannya.cricplexheros.util;

import java.io.Serializable;

/**
 * @author Ugam Sharma
 *
 */
public class ResponseStatusCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private ResponseStatusCode() {
	}

	
	public static int VALIDATION_FAILED_CODE = 400;
	
	public static String BADREQUEST_CODE = "Bad request !";
	
	public static String VALIDATION_FAILED_TEXT = "Validation failed.";
	
	public static int OK_CODE = 200;
	
	public static int SERVER_UNAVAILABLE_CODE = 500;
	
	public static String SERVER_UNAVAILABLE_TEXT = "Server unavailable!";
	
	public static String OK_TEXT = "Success";
	
	public static int UNAUTHORISED_ACCESS = 401;
	
	
}
