/**
 * 
 */
package com.aannya.cricplexheros.service.impl;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aannya.cricplexheros.constants.SmsConstants;
import com.aannya.cricplexheros.dto.MobileOtpDto;
import com.aannya.cricplexheros.dto.OtpDTO;
import com.aannya.cricplexheros.dto.UserSmsDTO;
import com.aannya.cricplexheros.scorecard.model.Otp;
import com.aannya.cricplexheros.scorecard.repository.OtpRepository;
import com.aannya.cricplexheros.service.OtpService;
import com.aannya.cricplexheros.util.SmsUtility;

/**
 * @author Babban
 *
 */
@Service
public class OtpServiceImpl implements OtpService{
	
	@Autowired
	OtpRepository otpRepository;
	
	@Autowired
	SmsUtility smsUtility;

	@Override
	@Transactional
	public boolean send(String mobileNumber) {
		try {
			Otp otp = new Otp();
			String otpBody = null;
			if(mobileNumber != null) {
				otpBody = smsUtility.generateRandomNumber();
				otp.setMobileNumber(mobileNumber);
				otp.setOtp(otpBody);
				otp.setGeneratedAt(LocalDateTime.now());
				otp.setIs_expired(false);
				otp.setExpirationTime(LocalDateTime.now().plusMinutes(SmsConstants.OTP_EXPIRATION_TIME_IN_MINUTE));
			}
			if (otpRepository.save(otp) != null) {
				UserSmsDTO userSmsDTO = new UserSmsDTO();
				userSmsDTO.setToNumber(mobileNumber);
				StringBuilder message = new StringBuilder();
				message.append("Your OTP is :");
				message.append(otpBody);
				message.append(". Please enter it to ScoreBook App to verify your number.");
				userSmsDTO.setTextBody(message);
				SmsUtility.sendOtp(userSmsDTO);

				return true;
			}		
		} catch(Exception e) {
			return false;
		}		
		return false;
	}


	@Override
	public boolean validate(MobileOtpDto mobileOtpDto) {
		Otp otp = null;
		
		try {
			otp = otpRepository.validate(mobileOtpDto.getMobileNumber(), mobileOtpDto.getOtp());
			if(otp != null && !otp.isIs_expired() ) {				
				if(!LocalDateTime.now().isAfter(otp.getExpirationTime())) {
					otpRepository.expireOtp(mobileOtpDto.getMobileNumber(), mobileOtpDto.getOtp(), true);
						return true;
					}
				}
				
			
		} catch(Exception e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean regenerate(String mobileNumber) {		
		return send(mobileNumber);
	}




	

}
