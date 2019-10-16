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
@Table(name="bowler")
public class Bowler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="MATCH_ID")
	private String matchId;
	
	@Column(name="INNING_NUMBER")
	private Integer inningNumber; 
	
	@Column(name="TEAM_ID")
	private String teamId;
	
	@Column(name="RANDOMNUMBER")
	private long randomNumber;
	
	@Column(name="BOWLER_NAME")
	private String bowlerName;
	
	@Column(name="BOWLER_ID")
	private String bowlerId;
	
	@Column(name="BOWLER_OVERS")
	private int bowlerOvers;
	
	@Column(name="BOWLER_RUNS_CONCEDED")
	private int bowlerRunsConceded;
	
	@Column(name="BOWLER_WICKETS")
	private int bowlerWickets;
	
	@Column(name="BOWLER_MAIDENS")
	private int bowlerMaidens;
	/*
	@Column(name="BOWLER_ECON")
	private double bowlerEcon;*/
	
	public Bowler() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public Integer getInningNumber() {
		return inningNumber;
	}

	public void setInningNumber(Integer inningNumber) {
		this.inningNumber = inningNumber;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public long getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(long randomNumber) {
		this.randomNumber = randomNumber;
	}

	public String getBowlerName() {
		return bowlerName;
	}

	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}

	public String getBowlerId() {
		return bowlerId;
	}

	public void setBowlerId(String bowlerId) {
		this.bowlerId = bowlerId;
	}

	public int getBowlerOvers() {
		return bowlerOvers;
	}

	public void setBowlerOvers(int bowlerOvers) {
		this.bowlerOvers = bowlerOvers;
	}

	public int getBowlerRunsConceded() {
		return bowlerRunsConceded;
	}

	public void setBowlerRunsConceded(int bowlerRunsConceded) {
		this.bowlerRunsConceded = bowlerRunsConceded;
	}

	public int getBowlerWickets() {
		return bowlerWickets;
	}

	public void setBowlerWickets(int bowlerWickets) {
		this.bowlerWickets = bowlerWickets;
	}

	public int getBowlerMaidens() {
		return bowlerMaidens;
	}

	public void setBowlerMaidens(int bowlerMaidens) {
		this.bowlerMaidens = bowlerMaidens;
	}

	/*public double getBowlerEcon() {
		return bowlerEcon;
	}

	public void setBowlerEcon(double bowlerEcon) {
		this.bowlerEcon = bowlerEcon;
	}*/
	
}
