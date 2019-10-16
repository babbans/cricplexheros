/**
 * 
 */
package com.aannya.cricplexheros.dto;

/**
 * @author Aannya
 *
 */
public class MatchStatusDTO {
	
	private String matchId;
	private String matchResult;
	
	public MatchStatusDTO() {
		
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	public String getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}
	
}
