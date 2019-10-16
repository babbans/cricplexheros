/**
 * 
 */
package com.aannya.cricplexheros.dto;

import java.io.Serializable;

/**
 * @author Babban
 *
 */
public class BowlerSCDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer inningNumber; 
	private String teamId;
	private String bowlerName;
	private String bowlerId;	
	private Long bowlerOvers;	
	private Long bowlerRunsConceded;
	private Long bowlerWickets;	
	private Long bowlerMaidens;

	public BowlerSCDto() {}

	public BowlerSCDto(Integer inningNumber, String teamId, String bowlerName, String bowlerId, Long bowlerOvers,
			Long bowlerRunsConceded, Long bowlerWickets, Long bowlerMaidens) {
		super();
		this.inningNumber = inningNumber;
		this.teamId = teamId;
		this.bowlerName = bowlerName;
		this.bowlerId = bowlerId;
		this.bowlerOvers = bowlerOvers;
		this.bowlerRunsConceded = bowlerRunsConceded;
		this.bowlerWickets = bowlerWickets;
		this.bowlerMaidens = bowlerMaidens;
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

	public Long getBowlerOvers() {
		return bowlerOvers;
	}

	public void setBowlerOvers(Long bowlerOvers) {
		this.bowlerOvers = bowlerOvers;
	}

	public Long getBowlerRunsConceded() {
		return bowlerRunsConceded;
	}

	public void setBowlerRunsConceded(Long bowlerRunsConceded) {
		this.bowlerRunsConceded = bowlerRunsConceded;
	}

	public Long getBowlerWickets() {
		return bowlerWickets;
	}

	public void setBowlerWickets(Long bowlerWickets) {
		this.bowlerWickets = bowlerWickets;
	}

	public Long getBowlerMaidens() {
		return bowlerMaidens;
	}

	public void setBowlerMaidens(Long bowlerMaidens) {
		this.bowlerMaidens = bowlerMaidens;
	}

	
	
}
