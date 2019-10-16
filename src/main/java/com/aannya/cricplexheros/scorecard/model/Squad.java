package com.aannya.cricplexheros.scorecard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="squad")
public class Squad {//extends AuditModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "TOURNAMENT_ID")
	private String tournamentId;
	
	@Column(name="TEAM_ID")
	private long teamId;
	
	@Column(name="TEAM_NAME")
	private String teamName;
	
	@Column(name = "IS_BATTING_TEAM")
	private boolean isBattingTeam;
	
	@Column(name="PLAYER_ID")
	private String playerId; 
		
	@ManyToOne
	@JoinColumn(name = "match_id", nullable = false)
	@JsonIgnore
	private StartAMatch match;

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

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	
	public boolean isBattingTeam() {
		return isBattingTeam;
	}

	public void setBattingTeam(boolean isBattingTeam) {
		this.isBattingTeam = isBattingTeam;
	}

	public StartAMatch getMatch() {
		return match;
	}

	public void setMatch(StartAMatch match) {
		this.match = match;
	}
	
	
	
}
