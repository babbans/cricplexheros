/**
 * 
 */
package com.aannya.cricplexheros.dto;

/**
 * @author Babban
 *
 */
public class BatsmanStatDto {
	private String id;
	private String teamId;
	private String teamName;
	private String name;	
	private int matches;
	private int inning;
	private int runs;
	private int fours;
	private int sixes;
	private double sr;
	private Double avg;
	private int noc;
	private int hs;
	public String getId() {
		return id;
	}
	public String getTeamId() {
		return teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public String getName() {
		return name;
	}
	public int getMatches() {
		return matches;
	}
	public int getInning() {
		return inning;
	}
	public int getRuns() {
		return runs;
	}
	public int getFours() {
		return fours;
	}
	public int getSixes() {
		return sixes;
	}
	public double getSr() {
		return sr;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public void setInning(int inning) {
		this.inning = inning;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public void setSixes(int sixes) {
		this.sixes = sixes;
	}
	public void setSr(double sr) {
		this.sr = sr;
	}
	public Double getAvg() {
		return avg;
	}
	public void setAvg(Double avg) {
		this.avg = avg;
	}
	public int getNoc() {
		return noc;
	}
	public void setNoc(int noc) {
		this.noc = noc;
	}
	public int getHs() {
		return hs;
	}
	public void setHs(int hs) {
		this.hs = hs;
	}
	
	
}
