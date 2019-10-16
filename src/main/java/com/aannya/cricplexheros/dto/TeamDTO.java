/**
 * 
 */
package com.aannya.cricplexheros.dto;

import java.util.List;

import com.aannya.cricplexheros.user.model.User;


/**
 * @author Babban
 *
 */
public class TeamDTO {
	private String logoImgPath;
	private String name;
	private String location;
	private String tournamentId;
	private String userId;
	private List<User> playingEleven;
	public TeamDTO() {
		
	}

	public String getLogoImgPath() {
		return logoImgPath;
	}

	public void setLogoImgPath(String logoImgPath) {
		this.logoImgPath = logoImgPath;
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

	public String getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<User> getPlayingEleven() {
		return playingEleven;
	}

	public void setPlayingEleven(List<User> playingEleven) {
		this.playingEleven = playingEleven;
	}
	
	
}
