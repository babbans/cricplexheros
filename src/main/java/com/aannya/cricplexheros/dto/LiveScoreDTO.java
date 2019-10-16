/**
 * 
 */
package com.aannya.cricplexheros.dto;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author Babban
 *
 */
public class LiveScoreDTO implements Serializable{
	
	// match details
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tournamentId;
	
	private String userId;
	
	private String matchId;
		
	private String status;
	
	private String teamBatting_id;
	
	private String teamBowling_id;	
	
	private long randomNumber;
	
	//live score
	private Integer currentBallRun;
	
	private String isExtraRun;

	//live inning
	private Integer liveInningNumber;

	//extra runs
	private Integer byes;

	private Integer legbyes;

	private Integer wides;

	private Integer noballs;
	
	private Integer totalextra;
	
	//bowler
	private String bowlerId;
	
	private int maidanOvers;
	
	//batsmen
	private String strikerBatsmanId;
	
	private Integer strikerBatsman4s;
	
	private Integer strikerBatsman6s;
	
	private String striker_how_out;
	
	private String nonstrikerBatsmanId;
	
	private String nonstriker_how_out;
	
	private String deviceId;
	
	private int currentPartnershipRuns;
	
	private int currentPartnershipBalls;	
	
	public LiveScoreDTO() {
		
	}	

	public int getCurrentPartnershipRuns() {
		return currentPartnershipRuns;
	}


	public void setCurrentPartnershipRuns(int currentPartnershipRuns) {
		this.currentPartnershipRuns = currentPartnershipRuns;
	}


	public int getCurrentPartnershipBalls() {
		return currentPartnershipBalls;
	}


	public void setCurrentPartnershipBalls(int currentPartnershipBalls) {
		this.currentPartnershipBalls = currentPartnershipBalls;
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

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTeamBatting_id() {
		return teamBatting_id;
	}

	public void setTeamBatting_id(String teamBatting_id) {
		this.teamBatting_id = teamBatting_id;
	}

	public String getTeamBowling_id() {
		return teamBowling_id;
	}

	public void setTeamBowling_id(String teamBowling_id) {
		this.teamBowling_id = teamBowling_id;
	}

	public Integer getCurrentBallRun() {
		return currentBallRun;
	}

	public void setCurrentBallRun(Integer currentBallRun) {
		this.currentBallRun = currentBallRun;
	}

	public String getIsExtraRun() {
		return isExtraRun;
	}

	public void setIsExtraRun(String isExtraRun) {
		this.isExtraRun = isExtraRun;
	}

	public Integer getLiveInningNumber() {
		return liveInningNumber;
	}

	public void setLiveInningNumber(Integer liveInningNumber) {
		this.liveInningNumber = liveInningNumber;
	}

	public Integer getByes() {
		return byes;
	}

	public void setByes(Integer byes) {
		this.byes = byes;
	}

	public Integer getLegbyes() {
		return legbyes;
	}

	public void setLegbyes(Integer legbyes) {
		this.legbyes = legbyes;
	}

	public Integer getWides() {
		return wides;
	}

	public void setWides(Integer wides) {
		this.wides = wides;
	}

	public Integer getNoballs() {
		return noballs;
	}

	public void setNoballs(Integer noballs) {
		this.noballs = noballs;
	}

	public String getBowlerId() {
		return bowlerId;
	}

	public void setBowlerId(String bowlerId) {
		this.bowlerId = bowlerId;
	}

	public String getStrikerBatsmanId() {
		return strikerBatsmanId;
	}

	public void setStrikerBatsmanId(String strikerBatsmanId) {
		this.strikerBatsmanId = strikerBatsmanId;
	}

	public String getStriker_how_out() {
		return striker_how_out;
	}

	public void setStriker_how_out(String striker_how_out) {
		this.striker_how_out = striker_how_out;
	}

	public String getNonstrikerBatsmanId() {
		return nonstrikerBatsmanId;
	}

	public void setNonstrikerBatsmanId(String nonstrikerBatsmanId) {
		this.nonstrikerBatsmanId = nonstrikerBatsmanId;
	}

	public String getNonstriker_how_out() {
		return nonstriker_how_out;
	}

	public void setNonstriker_how_out(String nonstriker_how_out) {
		this.nonstriker_how_out = nonstriker_how_out;
	}

	public Integer getStrikerBatsman4s() {
		return strikerBatsman4s;
	}

	public void setStrikerBatsman4s(Integer strikerBatsman4s) {
		this.strikerBatsman4s = strikerBatsman4s;
	}

	public Integer getStrikerBatsman6s() {
		return strikerBatsman6s;
	}

	public void setStrikerBatsman6s(Integer strikerBatsman6s) {
		this.strikerBatsman6s = strikerBatsman6s;
	}

	public Integer getTotalextra() {
		return totalextra;
	}

	public void setTotalextra(Integer totalextra) {
		this.totalextra = totalextra;
	}

	public int getMaidanOvers() {
		return maidanOvers;
	}

	public void setMaidanOvers(int maidanOvers) {
		this.maidanOvers = maidanOvers;
	}

	public long getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(long randomNumber) {
		this.randomNumber = randomNumber;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	

		
}
