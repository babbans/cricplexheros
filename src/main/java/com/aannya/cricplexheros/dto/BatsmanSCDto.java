/**
 * 
 */
package com.aannya.cricplexheros.dto;

import java.io.Serializable;

/**
 * @author Babban
 *
 */
public class BatsmanSCDto implements Serializable{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String teamId;
	private Integer inningNumber; 
	private String batsmanName;
	private String batsmanId;
	private Long batsmanRuns;
	private Long batsman4Runs;
	private Long batsman6Runs;
	private Long batsmanBallsFaced;
	private String batsmanHowOut;
	
	public BatsmanSCDto() {}
	
	public BatsmanSCDto(String teamId, Integer inningNumber, String batsmanName, String batsmanId, Long batsmanRuns,
			Long batsman4Runs, Long batsman6Runs, Long batsmanBallsFaced, String batsmanHowOut) {
		super();
		this.teamId = teamId;
		this.inningNumber = inningNumber;
		this.batsmanName = batsmanName;
		this.batsmanId = batsmanId;
		this.batsmanRuns = batsmanRuns;
		this.batsman4Runs = batsman4Runs;
		this.batsman6Runs = batsman6Runs;
		this.batsmanBallsFaced = batsmanBallsFaced;
		this.batsmanHowOut = batsmanHowOut;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public Integer getInningNumber() {
		return inningNumber;
	}

	public void setInningNumber(Integer inningNumber) {
		this.inningNumber = inningNumber;
	}

	public String getBatsmanName() {
		return batsmanName;
	}

	public void setBatsmanName(String batsmanName) {
		this.batsmanName = batsmanName;
	}

	public String getBatsmanId() {
		return batsmanId;
	}

	public void setBatsmanId(String batsmanId) {
		this.batsmanId = batsmanId;
	}

	public Long getBatsmanRuns() {
		return batsmanRuns;
	}

	public void setBatsmanRuns(Long batsmanRuns) {
		this.batsmanRuns = batsmanRuns;
	}

	public Long getBatsman4Runs() {
		return batsman4Runs;
	}

	public void setBatsman4Runs(Long batsman4Runs) {
		this.batsman4Runs = batsman4Runs;
	}

	public Long getBatsman6Runs() {
		return batsman6Runs;
	}

	public void setBatsman6Runs(Long batsman6Runs) {
		this.batsman6Runs = batsman6Runs;
	}

	public Long getBatsmanBallsFaced() {
		return batsmanBallsFaced;
	}

	public void setBatsmanBallsFaced(Long batsmanBallsFaced) {
		this.batsmanBallsFaced = batsmanBallsFaced;
	}

	public String getBatsmanHowOut() {
		return batsmanHowOut;
	}

	public void setBatsmanHowOut(String batsmanHowOut) {
		this.batsmanHowOut = batsmanHowOut;
	}
	
	
	
}
