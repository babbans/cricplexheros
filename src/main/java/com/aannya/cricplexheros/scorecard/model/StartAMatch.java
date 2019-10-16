/**
 * 
 */
package com.aannya.cricplexheros.scorecard.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Babban
 *
 */
@Entity
@Table(name="startmatch")
public class StartAMatch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="TOURNAMENT_ID")
	private String tournamentId;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="TEAMA")
	private String teama_id;
	
	@Column(name="TEAMB")
	private String teamb_id;
	
	@Column(name="TEAMA_NAME")
	@NonNull
	private String teama_name;
	
	@NonNull
	@Column(name="TEAMB_NAME")
	private String teamb_name;
	
	@Column(name="TEAMA_LOGO")
	private String teama_logo;
	
	@Column(name="TEAMB_LOGO")
	private String teamb_logo;
	
	@Column(name="TEAMA_SCORE")
	private int teama_score;
	
	@Column(name="TEAMB_SCORE")
	private int teamb_score;
	
	@Column(name="TEAMA_WICKET")
	private int teama_wicket;
	
	@Column(name="TEAMA_OVERS")
	private double teama_overs;
	
	@Column(name="TEAMB_OVERS")
	private double teamb_overs;
	
	@Column(name="TEAMB_WICKET")
	private int teamb_wicket;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="TOSSRESULT")
	private String tossResult;
	
	@Column(name="MATCHTYPE")
	private String matchType;
	
	@Column(name="MATCHRESULT")
	private String matchResult;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="NOOFOVER")
	private String noOfOver;
	
	@Column(name="GROUNDLOCATION")
	private String groundLocation;
	
	@Column(name="DATETIME")
	private String datetime;
	
	@Column(name="BALLTYPE")
	private String ballType;
	
	@Column(name="COUNTNOBALLRUN")
	private String countNoBallRun;
	
	@Column(name="ELECTEDTOBAT")
	private String electedToBat;
	
	@Column(name="STRIKERBATSMAN_ID")
	private String strikerBatsman_id;
	
	@Column(name="NONSTRIKERBATSMAN_ID")
	private String nonstrikerBatsman_id;
	
	@Column(name="BOWLER_ID")
	private String bowler_id;
	
	@Column(name="PLAYINGELEVENTEAMA_COUNT")
	private long playingElevenTeamaCount;
	
	@Column(name="PLAYINGELEVENTEAMB_COUNT")
	private long playingElevenTeambCount;
	
	@Column(name="TEAMACAPTAIN_ID")
	private String teamaCaptain_id;
	
	@Column(name="TEAMAWIKETKEEPER_ID")
	private String teamaWicketKeeper_id;
	
	@Column(name="TEAMBCAPTAIN_ID")
	private String teambCaptain_id;
	
	@Column(name="TEAMBWIKETKEEPER_ID")
	private String teambWicketKeeper_id;
	
	@Column(name="CREATED_DATE")
	private Date creationDate;
	
	@Column(name="UPDATED_ON")
	private Date updatedOn;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "match")
	@JsonIgnore
	Set<Squad> squad = new HashSet<>();
	
	public StartAMatch() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTeama_id() {
		return teama_id;
	}

	public void setTeama_id(String teama_id) {
		this.teama_id = teama_id;
	}

	public String getTeamb_id() {
		return teamb_id;
	}

	public void setTeamb_id(String teamb_id) {
		this.teamb_id = teamb_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTossResult() {
		return tossResult;
	}

	public void setTossResult(String tossResult) {
		this.tossResult = tossResult;
	}

	public String getMatchType() {
		return matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	public String getNoOfOver() {
		return noOfOver;
	}

	public void setNoOfOver(String noOfOver) {
		this.noOfOver = noOfOver;
	}

	public String getGroundLocation() {
		return groundLocation;
	}

	public void setGroundLocation(String groundLocation) {
		this.groundLocation = groundLocation;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getBallType() {
		return ballType;
	}

	public void setBallType(String ballType) {
		this.ballType = ballType;
	}

	public String getCountNoBallRun() {
		return countNoBallRun;
	}

	public void setCountNoBallRun(String countNoBallRun) {
		this.countNoBallRun = countNoBallRun;
	}

	public String getElectedToBat() {
		return electedToBat;
	}

	public void setElectedToBat(String electedToBat) {
		this.electedToBat = electedToBat;
	}

	public String getStrikerBatsman_id() {
		return strikerBatsman_id;
	}

	public void setStrikerBatsman_id(String strikerBatsman_id) {
		this.strikerBatsman_id = strikerBatsman_id;
	}

	public String getNonstrikerBatsman_id() {
		return nonstrikerBatsman_id;
	}

	public void setNonstrikerBatsman_id(String nonstrikerBatsman_id) {
		this.nonstrikerBatsman_id = nonstrikerBatsman_id;
	}

	public String getBowler_id() {
		return bowler_id;
	}

	public void setBowler_id(String bowler_id) {
		this.bowler_id = bowler_id;
	}

	public long getPlayingElevenTeamaCount() {
		return playingElevenTeamaCount;
	}

	public void setPlayingElevenTeamaCount(long playingElevenTeamaCount) {
		this.playingElevenTeamaCount = playingElevenTeamaCount;
	}

	public long getPlayingElevenTeambCount() {
		return playingElevenTeambCount;
	}

	public void setPlayingElevenTeambCount(long playingElevenTeambCount) {
		this.playingElevenTeambCount = playingElevenTeambCount;
	}

	public String getTeamaCaptain_id() {
		return teamaCaptain_id;
	}

	public void setTeamaCaptain_id(String teamaCaptain_id) {
		this.teamaCaptain_id = teamaCaptain_id;
	}

	public String getTeamaWicketKeeper_id() {
		return teamaWicketKeeper_id;
	}

	public void setTeamaWicketKeeper_id(String teamaWicketKeeper_id) {
		this.teamaWicketKeeper_id = teamaWicketKeeper_id;
	}

	public String getTeambCaptain_id() {
		return teambCaptain_id;
	}

	public void setTeambCaptain_id(String teambCaptain_id) {
		this.teambCaptain_id = teambCaptain_id;
	}

	public String getTeambWicketKeeper_id() {
		return teambWicketKeeper_id;
	}

	public void setTeambWicketKeeper_id(String teambWicketKeeper_id) {
		this.teambWicketKeeper_id = teambWicketKeeper_id;
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

	public String getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}

	public String getTeama_name() {
		return teama_name;
	}

	public void setTeama_name(String teama_name) {
		this.teama_name = teama_name;
	}

	public String getTeamb_name() {
		return teamb_name;
	}

	public void setTeamb_name(String teamb_name) {
		this.teamb_name = teamb_name;
	}

	public String getTeama_logo() {
		return teama_logo;
	}

	public void setTeama_logo(String teama_logo) {
		this.teama_logo = teama_logo;
	}

	public String getTeamb_logo() {
		return teamb_logo;
	}

	public void setTeamb_logo(String teamb_logo) {
		this.teamb_logo = teamb_logo;
	}

	public int getTeama_score() {
		return teama_score;
	}

	public void setTeama_score(int teama_score) {
		this.teama_score = teama_score;
	}

	public int getTeamb_score() {
		return teamb_score;
	}

	public void setTeamb_score(int teamb_score) {
		this.teamb_score = teamb_score;
	}

	public int getTeama_wicket() {
		return teama_wicket;
	}

	public void setTeama_wicket(int teama_wicket) {
		this.teama_wicket = teama_wicket;
	}

	public int getTeamb_wicket() {
		return teamb_wicket;
	}

	public void setTeamb_wicket(int teamb_wicket) {
		this.teamb_wicket = teamb_wicket;
	}

	public double getTeama_overs() {
		return teama_overs;
	}

	public void setTeama_overs(double teama_overs) {
		this.teama_overs = teama_overs;
	}

	public double getTeamb_overs() {
		return teamb_overs;
	}

	public void setTeamb_overs(double teamb_overs) {
		this.teamb_overs = teamb_overs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Squad> getSquad() {
		return squad;
	}

	public void setSquad(Set<Squad> squad) {
		this.squad = squad;
	}
	

}
