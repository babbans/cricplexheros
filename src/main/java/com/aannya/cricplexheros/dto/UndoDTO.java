/**
 * 
 */
package com.aannya.cricplexheros.dto;

import java.io.Serializable;

/**
 * @author Babban
 *
 */
public class UndoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String matchId;
		
	private long randomNumber;
	
	public UndoDTO() {
		
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public long getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(long randomNumber) {
		this.randomNumber = randomNumber;
	}

	
}
