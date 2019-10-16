/**
 * 
 */
package com.aannya.cricplexheros.scorecard.model;

import java.io.Serializable;

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
@Table(name="inning")
public class Inning implements Serializable{

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
	
	@Column(name="MATCH_ID")
	private String matchId;
	
	@Column(name="RANDOMNUMBER")
	private long randomNumber;
	
	@Column(name="NUMBER")
	private int number;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="SHORT_NAME")
	private String shortName;
	
	@Column(name="STATUS")
	private int status;
	
	@Column(name="RESULT")
	private int result;
	
	@Column(name="BATTTING_TEAM_ID")
	private String battingTeamId;
	
	@Column(name="FIELDING_TEAM_ID")
	private String fieldingTeamId;
	
	@Column(name="SCORES")
	private int scores;
	
	@Column(name="INNING_OVER")
	private int inningOver;
	
	@Column(name="INNING_CURRENT_OVER")
	private int currentOverNumber;
		
	public Inning() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	
	public long getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(long randomNumber) {
		this.randomNumber = randomNumber;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getBattingTeamId() {
		return battingTeamId;
	}

	public void setBattingTeamId(String battingTeamId) {
		this.battingTeamId = battingTeamId;
	}

	public String getFieldingTeamId() {
		return fieldingTeamId;
	}

	public void setFieldingTeamId(String fieldingTeamId) {
		this.fieldingTeamId = fieldingTeamId;
	}

	public int getScores() {
		return scores;
	}

	public void setScores(int scores) {
		this.scores = scores;
	}

	public int getInningOver() {
		return inningOver;
	}

	public void setInningOver(int inningOver) {
		this.inningOver = inningOver;
	}

	public int getCurrentOverNumber() {
		return currentOverNumber;
	}

	public void setCurrentOverNumber(int currentOverNumber) {
		this.currentOverNumber = currentOverNumber;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
