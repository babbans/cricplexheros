/**
 * 
 */
package com.aannya.cricplexheros.dto;

import java.io.Serializable;

/**
 * @author Babban
 *
 */
public class BowlerStatDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String teamId;
	private String teamName;
	private String name;	
	private int runs;
	private int matches;
	private int overs;
	private int wickets;	
	private int maidens;
	private double econ;
	private double sr;
	private double avg;
	
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public int getOvers() {
		return overs;
	}
	public void setOvers(int overs) {
		this.overs = overs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public int getMaidens() {
		return maidens;
	}
	public void setMaidens(int maidens) {
		this.maidens = maidens;
	}
	public double getEcon() {
		return econ;
	}
	public void setEcon(double econ) {
		this.econ = econ;
	}
	public double getSr() {
		return sr;
	}
	public void setSr(double sr) {
		this.sr = sr;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	

}
