/**
 * 
 */
package com.aannya.cricplexheros.scorecard.model;

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
@Table(name="tournament")
public class Tournament {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	private long id;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="BANNER_IMG_PATH")
	private String bannerImgPath;
	
	@Column(name="LOGO_IMG_PATH")
	private String logoImgPath;	
	
	@Column(name="TOURNAMENT_NAME")
	private String tournamentName;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="GROUND")
	private String ground;
	
	@Column(name="ORGANIZER_NAME")
	private String organizerName;
	
	@Column(name="ORGANIZER_NUMBER")
	private String organizerNumber;
	
	@Column(name="ALLOW_PLAYERS_TO_CONTACT_FOR_REGISTRATION")
	private String allowPlayersToConatctForRegistration;
	
	@Column(name="IS_ACTIVE")
	private String isActive;	
	
	@Column(name="START_DATE")
	private String startDate;
	
	@Column(name="END_DATE")
	private String endDate;
	
	@Column(name="CREATED_ON")
	private Date createdOn;
	
	@Column(name="UPDATED_ON")
	private Date updatedOn;
	
	@Column(name="BOWL_TYPE")
	private String bowlType;
	
	@Column(name="MATCH_TYPE")
	private String matchType;
	
	@Column(name="ABOUT_TOURNAMENT")
	private String aboutTournament;
	
	public Tournament() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBannerImgPath() {
		return bannerImgPath;
	}

	public void setBannerImgPath(String bannerImgPath) {
		this.bannerImgPath = bannerImgPath;
	}

	public String getLogoImgPath() {
		return logoImgPath;
	}

	public void setLogoImgPath(String logoImgPath) {
		this.logoImgPath = logoImgPath;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGround() {
		return ground;
	}

	public void setGround(String ground) {
		this.ground = ground;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public String getOrganizerNumber() {
		return organizerNumber;
	}

	public void setOrganizerNumber(String organizerNumber) {
		this.organizerNumber = organizerNumber;
	}

	public String getAllowPlayersToConatctForRegistration() {
		return allowPlayersToConatctForRegistration;
	}

	public void setAllowPlayersToConatctForRegistration(String allowPlayersToConatctForRegistration) {
		this.allowPlayersToConatctForRegistration = allowPlayersToConatctForRegistration;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getBowlType() {
		return bowlType;
	}

	public void setBowlType(String bowlType) {
		this.bowlType = bowlType;
	}

	public String getMatchType() {
		return matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	public String getAboutTournament() {
		return aboutTournament;
	}

	public void setAboutTournament(String aboutTournament) {
		this.aboutTournament = aboutTournament;
	}

	
	
}
