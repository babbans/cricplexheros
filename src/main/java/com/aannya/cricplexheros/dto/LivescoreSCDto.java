/**
 * 
 */
package com.aannya.cricplexheros.dto;

import java.io.Serializable;

/**
 * @author Babban
 *
 */
public class LivescoreSCDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long runs;
	private Integer inningNumber;
	private Integer overs;
	private Double current_overs;
	private Long wickets;
	public LivescoreSCDto(Long runs, Integer inningNumber, Integer overs, Double current_overs, Long wickets) {
		super();
		this.runs = runs;
		this.inningNumber = inningNumber;
		this.overs = overs;
		this.current_overs = current_overs;
		this.wickets = wickets;
	}
	public Long getRuns() {
		return runs;
	}
	public void setRuns(Long runs) {
		this.runs = runs;
	}
	public Integer getInningNumber() {
		return inningNumber;
	}
	public void setInningNumber(Integer inningNumber) {
		this.inningNumber = inningNumber;
	}
	public Integer getOvers() {
		return overs;
	}
	public void setOvers(Integer overs) {
		this.overs = overs;
	}
	public Double getCurrent_overs() {
		return current_overs;
	}
	public void setCurrent_overs(Double current_overs) {
		this.current_overs = current_overs;
	}
	public Long getWickets() {
		return wickets;
	}
	public void setWickets(Long wickets) {
		this.wickets = wickets;
	}

	/*
	 * private Integer currentPartnershipRuns; private Integer
	 * currentPartnershipBalls;
	 */
	
	
}
