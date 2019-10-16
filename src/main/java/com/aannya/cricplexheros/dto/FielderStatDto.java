/**
 * 
 */
package com.aannya.cricplexheros.dto;

/**
 * @author Babban
 *
 */
public class FielderStatDto {
	private long id;
	private String teamId;
	private String teamName;
	private String name;	
	//private int matches;
	private int dismissals;
	private int catches;
	private int runOuts;
	private int stumping;
	
	public FielderStatDto() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	/*
	 * public int getMatches() { return matches; }
	 * 
	 * public void setMatches(int matches) { this.matches = matches; }
	 */

	public int getDismissals() {
		return dismissals;
	}

	public void setDismissals(int dismissals) {
		this.dismissals = dismissals;
	}

	public int getCatches() {
		return catches;
	}

	public void setCatches(int catches) {
		this.catches = catches;
	}

	public int getRunOuts() {
		return runOuts;
	}

	public void setRunOuts(int runOuts) {
		this.runOuts = runOuts;
	}

	public int getStumping() {
		return stumping;
	}

	public void setStumping(int stumping) {
		this.stumping = stumping;
	}
		
	
}
