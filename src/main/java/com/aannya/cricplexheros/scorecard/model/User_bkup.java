/**
 * 
 */
package com.aannya.cricplexheros.scorecard.model;

import java.io.Serializable;
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
@Table(name="USER")
public class User_bkup implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="DOB")
	private String dob;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name="PLAYER_ROLE")
	private String playerRole;	
	
	@Column(name="BATTING_STYLE")
	private String battingStyle;
	
	@Column(name="BOWLING_STYLE")
	private String bowlingStyle;
	
	@Column(name="PROFILE_IMG_PATH")
	private String profileImgPath;
	
	@Column(name="PIN")
	private String pin;
	
	@Column(name="TEAM_ID")
	private String teamId;
		
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@Column(name="CREATED_DATE")
	private Date creationDate;
	
	@Column(name="UPDATED_ON")
	private Date updatedOn;
	
	public User_bkup() {
		
	}

	public User_bkup(long id, String name, String location, String country, String dob, String email, String mobileNumber,
			String playerRole, String battingStyle, String bowlingStyle, String profileImgPath, String pin,
			String isActive, Date creationDate, Date updatedOn) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.country = country;
		this.dob = dob;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.playerRole = playerRole;
		this.battingStyle = battingStyle;
		this.bowlingStyle = bowlingStyle;
		this.profileImgPath = profileImgPath;
		this.pin = pin;
		this.isActive = isActive;
		this.creationDate = creationDate;
		this.updatedOn = updatedOn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getProfileImgPath() {
		return profileImgPath;
	}

	public void setProfileImgPath(String profileImgPath) {
		this.profileImgPath = profileImgPath;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

		
	
}
