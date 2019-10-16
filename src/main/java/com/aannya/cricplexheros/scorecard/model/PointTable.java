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
@Table(name="point_table")
public class PointTable implements Serializable{

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
	
	@Column(name="TEAM_NAME")
	private String teamName;
	
	@Column(name="MATCH_PLAYED")
	private int matchPlayed;

	@Column(name="MATCH_WON")
	private int matchWon;
	
	@Column(name="MATCH_LOST")
	private int matchLost;
	
	@Column(name="MATCH_TIED")
	private int matchTied;
	
	@Column(name="MATCH_NO_RESULT")
	private int matchNoResult;
	
	@Column(name="POINTS")
	private int points;
	
	@Column(name="NETRUNRATE")
	private double netRunRate;
	
	public PointTable() {
		
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

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getMatchPlayed() {
		return matchPlayed;
	}

	public void setMatchPlayed(int matchPlayed) {
		this.matchPlayed = matchPlayed;
	}

	public int getMatchWon() {
		return matchWon;
	}

	public void setMatchWon(int matchWon) {
		this.matchWon = matchWon;
	}

	public int getMatchLost() {
		return matchLost;
	}

	public void setMatchLost(int matchLost) {
		this.matchLost = matchLost;
	}

	public int getMatchTied() {
		return matchTied;
	}

	public void setMatchTied(int matchTied) {
		this.matchTied = matchTied;
	}

	public int getMatchNoResult() {
		return matchNoResult;
	}

	public void setMatchNoResult(int matchNoResult) {
		this.matchNoResult = matchNoResult;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public double getNetRunRate() {
		return netRunRate;
	}

	public void setNetRunRate(double netRunRate) {
		this.netRunRate = netRunRate;
	}

	
	
}
