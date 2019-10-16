/**
 * 
 */
package com.aannya.cricplexheros.dto;

/**
 * @author Babban
 *
 */
public class LoginDTO {
	private String mobileNumber;	
	private String pin;
	
	public LoginDTO() {
		
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
}
