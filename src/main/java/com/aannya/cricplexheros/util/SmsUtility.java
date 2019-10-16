package com.aannya.cricplexheros.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.aannya.cricplexheros.constants.SmsConstants;
import com.aannya.cricplexheros.dto.UserSmsDTO;
@Component
public class SmsUtility {


	private SmsUtility() {

	}

	public static String sendOtp(UserSmsDTO userSmsDTO) {

		//Prepare Url
        URLConnection myURLConnection=null;
        URL myURL=null;
        BufferedReader reader=null;
		StringBuilder sbPostData = null;
		// encoding message
		String encodedMessageBody = null;
		String response = null;

		try {
			encodedMessageBody = URLEncoder.encode(userSmsDTO.getTextBody().toString(), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			
		}

        //Send SMS API
        String mainUrl="http://api.msg91.com/api/sendhttp.php?";


		sbPostData = new StringBuilder(SmsConstants.API_URL);
		sbPostData.append(SmsConstants.AUTH_PARAM_KEY + SmsConstants.SMS_AUTH_KEY);
		sbPostData.append(SmsConstants.MOBILE_PARAM_KEY + userSmsDTO.getToNumber());
		sbPostData.append(SmsConstants.ROUTE_PARAM_KEY + SmsConstants.ROUTE);
		sbPostData.append(SmsConstants.MESSAGE_PARAM_KEY + encodedMessageBody);
		sbPostData.append(SmsConstants.SENDER_PARAM_KEY + SmsConstants.SENDER_ID);

		mainUrl = sbPostData.toString();
        try
        {
            //prepare connection
            myURL = new URL(mainUrl);
            myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            //reading response
           
            while ((response = reader.readLine()) != null)
            //print response
            System.out.println(response);

            //finally close connection
            reader.close();
        } catch (IOException e) {

		}

		finally {

		}

		return response;
	}
	public String generateRandomNumber() {
		// To generate a 4-digit number
		Random random = new Random();
		return String.valueOf(1000 + random.nextInt(9000));
	}

}
