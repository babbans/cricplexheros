/**
 * 
 */
package com.aannya.cricplexheros.dto;

import java.io.Serializable;
import java.util.Map;

public class ResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int responseCode;
	private String responseText;
	private boolean isRequestSuccess = false;
	private Map<String, Object> errors;
	private Map<String, Object> response;
	private String message;
	/**
	 * 
	 */
	public ResponseDTO() {

	}
	
	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public Map<String, Object> getResponse() {
		return response;
	}



	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}



	public boolean isRequestSuccess() {
		return isRequestSuccess;
	}



	public void setRequestSuccess(boolean isRequestSuccess) {
		this.isRequestSuccess = isRequestSuccess;
	}



	public Map<String, Object> getErrors() {
		return errors;
	}


	public void setErrors(Map<String, Object> errors) {
		this.errors = errors;
	}


	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseText() {
		return responseText;
	}
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	
}
