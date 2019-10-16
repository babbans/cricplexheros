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
@Table(name="batsmen")
public class Batsmen implements Serializable{

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
	
	@Column(name="TEAM_ID")
	private String teamId;
	
	@Column(name="RANDOMNUMBER")
	private long randomNumber;
	
	@Column(name="INNING_NUMBER")
	private int inningNumber; 
	
	@Column(name="BATSMAN_NAME")
	private String batsmanName;
	
	@Column(name="BATSMAN_ID")
	private String batsmanId;
	
	@Column(name="BATSMAN_RUNS")
	private int batsmanRuns;
	
	@Column(name="BATSMAN_4_RUNS")
	private int batsman4Runs;
	
	@Column(name="BATSMAN_6_RUNS")
	private int batsman6Runs;
	
	@Column(name="BATSMAN_BALLS_FACED")
	private int batsmanBallsFaced;
	
	@Column(name="BATSMAN_HOW_OUT")
	private String batsmanHowOut;
	
	@Column(name="BATSMAN_STRIKE_RATE")
	private double batsmanStrikeRate;
	
	public Batsmen() {
		
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

	public int getInningNumber() {
		return inningNumber;
	}

	public void setInningNumber(int inningNumber) {
		this.inningNumber = inningNumber;
	}

	public String getBatsmanName() {
		return batsmanName;
	}

	public void setBatsmanName(String batsmanName) {
		this.batsmanName = batsmanName;
	}

	public String getBatsmanId() {
		return batsmanId;
	}

	public void setBatsmanId(String batsmanId) {
		this.batsmanId = batsmanId;
	}

	public int getBatsmanRuns() {
		return batsmanRuns;
	}

	public void setBatsmanRuns(int batsmanRuns) {
		this.batsmanRuns = batsmanRuns;
	}

	public int getBatsman4Runs() {
		return batsman4Runs;
	}

	public void setBatsman4Runs(int batsman4Runs) {
		this.batsman4Runs = batsman4Runs;
	}

	public int getBatsman6Runs() {
		return batsman6Runs;
	}

	public void setBatsman6Runs(int batsman6Runs) {
		this.batsman6Runs = batsman6Runs;
	}

	public int getBatsmanBallsFaced() {
		return batsmanBallsFaced;
	}

	public void setBatsmanBallsFaced(int batsmanBallsFaced) {
		this.batsmanBallsFaced = batsmanBallsFaced;
	}

	public String getBatsmanHowOut() {
		return batsmanHowOut;
	}

	public void setBatsmanHowOut(String batsmanHowOut) {
		this.batsmanHowOut = batsmanHowOut;
	}

	public double getBatsmanStrikeRate() {
		return batsmanStrikeRate;
	}

	public void setBatsmanStrikeRate(double batsmanStrikeRate) {
		this.batsmanStrikeRate = batsmanStrikeRate;
	}

		
}
