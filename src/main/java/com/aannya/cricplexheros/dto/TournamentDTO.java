/**
 * 
 */
package com.aannya.cricplexheros.dto;
/**
 * @author Babban
 *
 */
public class TournamentDTO {
	private String userId;
	private String bannerImgPath;
	private String logoImgPath;		
	private String tournamentName;
	private String city;
	private String ground;	
	private String organizerName;	
	private String organizerNumber;	
	private String allowPlayersToConatctForRegistration;	
	private String startDate;	
	private String endDate;
	private String bowlType;	
	private String matchType;	
	private String aboutTournament;
	
	public TournamentDTO() {
		
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
