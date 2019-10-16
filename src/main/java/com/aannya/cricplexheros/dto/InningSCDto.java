/**
 * 
 */
package com.aannya.cricplexheros.dto;

import java.io.Serializable;

/**
 * @author Babban
 *
 */
public class InningSCDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer number;	
	private String name;
	private Integer status;
	private Integer result;
	private String battingTeamId;
	private String fieldingTeamId;
	private Long scores;
	private Long inningOver;
	public InningSCDto(Integer number, String name, Integer status, Integer result, String battingTeamId,
			String fieldingTeamId, Long scores, Long inningOver) {
		super();
		this.number = number;
		this.name = name;
		this.status = status;
		this.result = result;
		this.battingTeamId = battingTeamId;
		this.fieldingTeamId = fieldingTeamId;
		this.scores = scores;
		this.inningOver = inningOver;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public String getBattingTeamId() {
		return battingTeamId;
	}
	public void setBattingTeamId(String battingTeamId) {
		this.battingTeamId = battingTeamId;
	}
	public String getFieldingTeamId() {
		return fieldingTeamId;
	}
	public void setFieldingTeamId(String fieldingTeamId) {
		this.fieldingTeamId = fieldingTeamId;
	}
	public Long getScores() {
		return scores;
	}
	public void setScores(Long scores) {
		this.scores = scores;
	}
	public Long getInningOver() {
		return inningOver;
	}
	public void setInningOver(Long inningOver) {
		this.inningOver = inningOver;
	}
	
	
	

}
