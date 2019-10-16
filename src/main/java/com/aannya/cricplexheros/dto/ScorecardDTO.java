/**
 * 
 */
package com.aannya.cricplexheros.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Babban
 *
 */
public class ScorecardDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<BatsmanSCDto> firstInningBatsmen;
	private List<BatsmanSCDto> secondInningBatsmen;
	
	private List<BowlerSCDto> firstInningBowler;
	private List<BowlerSCDto> secondInningBowler;
	
	private InningSCDto inningOne;
	private InningSCDto inningTwo;
	
	private ExtraRunSCDto extraRunsInningOne;
	private ExtraRunSCDto extraRunsInningTwo;
	
	private LivescoreSCDto firstInningScore;
	private LivescoreSCDto secondInningScore;
	
	private String status;
	
	private String matchResult;
	
	public ScorecardDTO() {
		
	}

	public List<BatsmanSCDto> getFirstInningBatsmen() {
		return firstInningBatsmen;
	}

	public void setFirstInningBatsmen(List<BatsmanSCDto> firstInningBatsmen) {
		this.firstInningBatsmen = firstInningBatsmen;
	}

	public List<BatsmanSCDto> getSecondInningBatsmen() {
		return secondInningBatsmen;
	}

	public void setSecondInningBatsmen(List<BatsmanSCDto> secondInningBatsmen) {
		this.secondInningBatsmen = secondInningBatsmen;
	}

	public List<BowlerSCDto> getFirstInningBowler() {
		return firstInningBowler;
	}

	public void setFirstInningBowler(List<BowlerSCDto> firstInningBowler) {
		this.firstInningBowler = firstInningBowler;
	}

	public List<BowlerSCDto> getSecondInningBowler() {
		return secondInningBowler;
	}

	public void setSecondInningBowler(List<BowlerSCDto> secondInningBowler) {
		this.secondInningBowler = secondInningBowler;
	}

	public InningSCDto getInningOne() {
		return inningOne;
	}

	public void setInningOne(InningSCDto inningOne) {
		this.inningOne = inningOne;
	}

	public InningSCDto getInningTwo() {
		return inningTwo;
	}

	public void setInningTwo(InningSCDto inningTwo) {
		this.inningTwo = inningTwo;
	}

	public ExtraRunSCDto getExtraRunsInningOne() {
		return extraRunsInningOne;
	}

	public void setExtraRunsInningOne(ExtraRunSCDto extraRunsInningOne) {
		this.extraRunsInningOne = extraRunsInningOne;
	}

	public ExtraRunSCDto getExtraRunsInningTwo() {
		return extraRunsInningTwo;
	}

	public void setExtraRunsInningTwo(ExtraRunSCDto extraRunsInningTwo) {
		this.extraRunsInningTwo = extraRunsInningTwo;
	}

	public LivescoreSCDto getFirstInningScore() {
		return firstInningScore;
	}

	public void setFirstInningScore(LivescoreSCDto firstInningScore) {
		this.firstInningScore = firstInningScore;
	}

	public LivescoreSCDto getSecondInningScore() {
		return secondInningScore;
	}

	public void setSecondInningScore(LivescoreSCDto secondInningScore) {
		this.secondInningScore = secondInningScore;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}

			
}
