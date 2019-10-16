/**
 * 
 */
package com.aannya.cricplexheros.dto;

import javax.persistence.Column;

/**
 * @author Babban
 *
 */
public class UserDTO {
	
	private String profileImgPath;
	private String name;	
	private String location;
	private String country;
	private String dob;
	private String email;
	private String mobileNumber;
	private String playerRole;	
	private String battingStyle;
	private String bowlingStyle;
	private String pin;
	private String teamId;
     
	public UserDTO() {
    	
    }


	public String getProfileImgPath() {
		return profileImgPath;
	}


	public void setProfileImgPath(String profileImgPath) {
		this.profileImgPath = profileImgPath;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getPlayerRole() {
		return playerRole;
	}


	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}


	public String getBattingStyle() {
		return battingStyle;
	}


	public void setBattingStyle(String battingStyle) {
		this.battingStyle = battingStyle;
	}


	public String getBowlingStyle() {
		return bowlingStyle;
	}


	public void setBowlingStyle(String bowlingStyle) {
		this.bowlingStyle = bowlingStyle;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getTeamId() {
		return teamId;
	}


	public void setTeamId(String teamId) {
		this.teamId = teamId;
	} 
	

}

