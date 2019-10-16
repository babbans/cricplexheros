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
@Table(name="extra_runs")
public class ExtraRuns implements Serializable{

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
	
	@Column(name="INNING_NUMBER")
	private int inningNumber;
	
	@Column(name="TEAM_ID")
	private String teamId;
	
	@Column(name="RANDOMNUMBER")
	private long randomNumber;
	
	@Column(name="BYES")
	private int byes;
	
	@Column(name="LEGBYES")
	private int legbyes;
	
	@Column(name="WIDES")
	private int wides;
	
	@Column(name="NOBALLS")
	private int noballs;
	
	@Column(name="TOTAL")
	private int total;
	
	public ExtraRuns() {
		
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

	public int getInningNumber() {
		return inningNumber;
	}

	public void setInningNumber(int inningNumber) {
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

	public int getByes() {
		return byes;
	}

	public void setByes(int byes) {
		this.byes = byes;
	}

	public int getLegbyes() {
		return legbyes;
	}

	public void setLegbyes(int legbyes) {
		this.legbyes = legbyes;
	}

	public int getWides() {
		return wides;
	}

	public void setWides(int wides) {
		this.wides = wides;
	}

	public int getNoballs() {
		return noballs;
	}

	public void setNoballs(int noballs) {
		this.noballs = noballs;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
