/**
 * 
 */
package com.aannya.cricplexheros.scorecard.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Babban
 *
 */
@Entity
@Table(name = "otp")
public class Otp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name="OTP")
	private String otp;
	
	@Column(name="IS_EXPIRED")
	private boolean is_expired;
	
	@Column(name="GENERATED_AT")
	private LocalDateTime generatedAt;
	
	@Column(name="EXPIRATION_TIME")
	private LocalDateTime expirationTime;
	
	public Otp() {
		
	}
	
	
	public Otp(long id, String mobileNumber, String otp, boolean is_expired, LocalDateTime generatedAt, LocalDateTime expirationTime) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.otp = otp;
		this.is_expired = is_expired;
		this.generatedAt = generatedAt;
		this.expirationTime = expirationTime;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public boolean isIs_expired() {
		return is_expired;
	}
	public void setIs_expired(boolean is_expired) {
		this.is_expired = is_expired;
	}


	public LocalDateTime getGeneratedAt() {
		return generatedAt;
	}


	public void setGeneratedAt(LocalDateTime generatedAt) {
		this.generatedAt = generatedAt;
	}


	public LocalDateTime getExpirationTime() {
		return expirationTime;
	}


	public void setExpirationTime(LocalDateTime expirationTime) {
		this.expirationTime = expirationTime;
	}
	
	
	
	
}
