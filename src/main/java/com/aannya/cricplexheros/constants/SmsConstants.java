/**
 * 
 */
package com.aannya.cricplexheros.constants;

/**
 * @author Babban
 *
 */
public class SmsConstants {
	private SmsConstants() {
		
	}
	public static final long OTP_EXPIRATION_TIME_IN_MINUTE = 10;
	
	public static final String VERIFICATION_TYPE_MOBILE_SMS = "SMS";
	
	/*public static final String SMS_AUTH_KEY = "275325AdmsZ6jf0k5ccfd8d5";*/
	
	public static final String SMS_AUTH_KEY = "278516ANYWfGuhSt315cebc1b1";
	
	// Sender ID,While using route4 sender id should be 6 characters long.
	public static final String SENDER_ID = "CRPLEX";

	// define route
	public static final String ROUTE = "4";
	
	public static final String API_URL = "http://api.msg91.com/api/sendhttp.php?";
	
	public static final String AUTH_PARAM_KEY = "authkey=";
	
	public static final String MOBILE_PARAM_KEY = "&mobiles=";
	
	public static final String MESSAGE_PARAM_KEY = "&message=";
	
	public static final String ROUTE_PARAM_KEY = "&route=";
	
	public static final String SENDER_PARAM_KEY = "&sender=";
}
