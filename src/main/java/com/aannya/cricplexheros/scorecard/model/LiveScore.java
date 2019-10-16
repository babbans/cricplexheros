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
@Table(name="livescore")
public class LiveScore implements Serializable{

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
	
	@Column(name="CURRENT_PARTNERSHIP_RUNS")
	private int currentPartnershipRuns;
	
	@Column(name="CURRENT_PARTNERSHIP_BALLS")
	private int currentPartnershipBalls;
	
	@Column(name="RUNS")
	private int runs;
	
	@Column(name="INNING_NUMBER")
	private int inningNumber;
	
	@Column(name="OVERS")
	private int overs;
	
	@Column(name="CURRENT_OVERS")
	private double current_overs;
	
	@Column(name="WICKETS")
	private int wickets;
	
	@Column(name="TARGET")
	private int target;
	
	@Column(name="RUNRATE")
	private double runrate;
	
	@Column(name="REQUIREDRUNRATE")
	private double requiredRunrate;
	
	public LiveScore() {
		
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

	public long getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(long randomNumber) {
		this.randomNumber = randomNumber;
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

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getInningNumber() {
		return inningNumber;
	}

	public void setInningNumber(int inningNumber) {
		this.inningNumber = inningNumber;
	}

	public int getOvers() {
		return overs;
	}

	public void setOvers(int overs) {
		this.overs = overs;
	}

	public double getCurrent_overs() {
		return current_overs;
	}

	public void setCurrent_overs(double current_overs) {
		this.current_overs = current_overs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public double getRunrate() {
		return runrate;
	}

	public void setRunrate(double runrate) {
		this.runrate = runrate;
	}

	public double getRequiredRunrate() {
		return requiredRunrate;
	}

	public void setRequiredRunrate(double requiredRunrate) {
		this.requiredRunrate = requiredRunrate;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}


	
}
