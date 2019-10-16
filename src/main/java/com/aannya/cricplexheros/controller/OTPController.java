/**
 * 
 */
package com.aannya.cricplexheros.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aannya.cricplexheros.constants.KeyValueHolder;
import com.aannya.cricplexheros.dto.MobileDto;
import com.aannya.cricplexheros.dto.MobileOtpDto;
import com.aannya.cricplexheros.dto.ResponseDTO;
import com.aannya.cricplexheros.service.OtpService;
import com.aannya.cricplexheros.util.CommonValidationUtility;
import com.aannya.cricplexheros.util.ResponseStatusCode;

/**
 * @author Babban
 *
 */
@RestController
@RequestMapping(value="/api/otp")
public class OTPController {
	
	@Autowired
	OtpService otpService;
	
	@PostMapping(value = "/send")
	public ResponseDTO send(@RequestBody MobileDto dto) {
		Map<String, Object> errors = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		ResponseDTO responseDTO = new ResponseDTO();
	
		if (CommonValidationUtility.isEmpty(dto.getMobileNumber())) {
			errors.put(KeyValueHolder.MOBILE_NUMBER_KEY, KeyValueHolder.MOBILE_NUMBER_MSG);
		}
		
		if (CommonValidationUtility.isEmpty(errors)) {
			
			if (otpService.send(dto.getMobileNumber())) {
				responseDTO.setMessage("Otp sent successfully.");
				responseDTO.setErrors(null);
				responseDTO.setResponse(response);
				responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
				responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
				responseDTO.setRequestSuccess(true);				
			} else {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setMessage("Error while sending Otp.");
				responseDTO.setErrors(errors);
				responseDTO.setResponse(null);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} else {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setMessage("Error while sending Otp.");
			responseDTO.setErrors(errors);
			responseDTO.setResponse(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}
		return responseDTO;
	}
	
	@RequestMapping(value="/verify", method = RequestMethod.POST)
	public ResponseDTO verify (@RequestBody MobileOtpDto mobileOtpDto) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> errors = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		try {
			if (CommonValidationUtility.isEmpty(mobileOtpDto.getOtp())) {
				errors.put(KeyValueHolder.OTP_BLANK_KEY, KeyValueHolder.OTP_BLANK_MSG);
			}			
			if (CommonValidationUtility.isEmpty(errors)) {
				if (otpService.validate(mobileOtpDto)) {
					responseDTO.setMessage("Otp verified successfully.");
					responseDTO.setErrors(null);
					responseDTO.setResponse(response);
					responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
					responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
					responseDTO.setRequestSuccess(true);				
				}
				else {
					errors.put("server", "Service unavailable. Please try again!");
					responseDTO.setMessage("Error while verifying Otp.");
					responseDTO.setResponse(null);
					responseDTO.setErrors(errors);
					responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
					responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
					responseDTO.setRequestSuccess(false);
				}
			} else {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setMessage("Error while verifying Otp.");
				responseDTO.setResponse(null);
				responseDTO.setErrors(errors);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
			
		} catch (Exception e) {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setMessage("Error while verifying Otp.");
			responseDTO.setResponse(null);
			responseDTO.setErrors(errors);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}
		return responseDTO;
	}
	
	@PostMapping("resend")
	public ResponseDTO regenerate(@RequestBody MobileDto dto) {
		Map<String, Object> errors = new HashMap<>();
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		if (CommonValidationUtility.isEmpty(dto.getMobileNumber())) {
			errors.put(KeyValueHolder.MOBILE_NUMBER_KEY, KeyValueHolder.MOBILE_NUMBER_MSG);
		}
		
		if (CommonValidationUtility.isEmpty(errors)) {
			
			if (otpService.regenerate(dto.getMobileNumber())) {
				responseDTO.setMessage("Otp re-sent successfully.");
				responseDTO.setErrors(null);
				responseDTO.setResponse(response);
				responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
				responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
				responseDTO.setRequestSuccess(true);				
			} else {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setMessage("Error while re-sending Otp.");
				responseDTO.setErrors(errors);
				responseDTO.setResponse(null);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} else {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setMessage("Error while re-sending Otp.");
			responseDTO.setErrors(errors);
			responseDTO.setResponse(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}
		return responseDTO;
	}
	
	
}
