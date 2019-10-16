/**
 * 
 */
package com.aannya.cricplexheros.util;

import java.util.Map;

import com.aannya.cricplexheros.dto.ResponseDTO;

/**
 * @author Ugam Sharma
 *
 */
public class ResponseUtility {

	/**
	 * 
	 */
	public ResponseUtility() {
		// TODO Auto-generated constructor stub
	}

	
	public static ResponseDTO sendResponse(int responseCode, String responseText, Map<String, Object> errors, boolean isRequestSuccess) {
		
		ResponseDTO responseDTO = new ResponseDTO();
		
		responseDTO.setErrors(errors);
		responseDTO.setRequestSuccess(isRequestSuccess);
		responseDTO.setResponseCode(responseCode);
		responseDTO.setResponseText(responseText);
		
		return responseDTO;
		
	}
}
