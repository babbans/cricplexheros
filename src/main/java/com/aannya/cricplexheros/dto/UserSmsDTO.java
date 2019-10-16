/**
 * 
 */
package com.aannya.cricplexheros.dto;


public class UserSmsDTO {

	/**
	 * 
	 */
	public UserSmsDTO() {

	}
	
	private int id;
	
	private String fromNumber;
	
	private String toNumber;
	
	private StringBuilder textBody;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromNumber() {
		return fromNumber;
	}

	public void setFromNumber(String fromNumber) {
		this.fromNumber = fromNumber;
	}

	public String getToNumber() {
		return toNumber;
	}

	public void setToNumber(String toNumber) {
		this.toNumber = toNumber;
	}

	public StringBuilder getTextBody() {
		return textBody;
	}

	public void setTextBody(StringBuilder textBody) {
		this.textBody = textBody;
	}
	
	
	
	
	

}
