/**
 * 
 */
package com.aannya.cricplexheros.service;

import com.aannya.cricplexheros.dto.MobileOtpDto;

/**
 * @author Babban
 *
 */
public interface OtpService {
	
	public boolean send(String mobileNumber);
	
	public boolean validate(MobileOtpDto mobileOtpDto);
	
	public boolean regenerate(String mobileNumber);
	
}
