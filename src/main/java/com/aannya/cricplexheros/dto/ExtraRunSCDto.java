/**
 * 
 */
package com.aannya.cricplexheros.dto;

import java.io.Serializable;

/**
 * @author Babban
 *
 */
public class ExtraRunSCDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer inningNumber;
	private String teamId;
	private Long byes;	
	private Long legbyes;
	private Long wides;
	private Long noballs;
	private Long total;
	
	public ExtraRunSCDto(Integer inningNumber, String teamId, Long byes, Long legbyes, Long wides, Long noballs,
			Long total) {
		super();
		this.inningNumber = inningNumber;
		this.teamId = teamId;
		this.byes = byes;
		this.legbyes = legbyes;
		this.wides = wides;
		this.noballs = noballs;
		this.total = total;
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
	public Long getByes() {
		return byes;
	}
	public void setByes(Long byes) {
		this.byes = byes;
	}
	public Long getLegbyes() {
		return legbyes;
	}
	public void setLegbyes(Long legbyes) {
		this.legbyes = legbyes;
	}
	public Long getWides() {
		return wides;
	}
	public void setWides(Long wides) {
		this.wides = wides;
	}
	public Long getNoballs() {
		return noballs;
	}
	public void setNoballs(Long noballs) {
		this.noballs = noballs;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	
	

}
