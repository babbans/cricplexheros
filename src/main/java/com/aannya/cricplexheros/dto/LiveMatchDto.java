/**
 * 
 */
package com.aannya.cricplexheros.dto;

import java.util.Map;

import com.aannya.cricplexheros.scorecard.model.Batsmen;
import com.aannya.cricplexheros.scorecard.model.Bowler;
import com.aannya.cricplexheros.scorecard.model.ExtraRuns;
import com.aannya.cricplexheros.scorecard.model.Inning;
import com.aannya.cricplexheros.scorecard.model.LiveScore;

/**
 * @author Babban
 *
 */
public class LiveMatchDto {
	
	private LiveScore liveScore;
	private ExtraRuns extraRuns;
	private Inning inning;
	private Bowler bowler;
	private Map<String, Batsmen> batsmens;
	
	public LiveMatchDto() {
		
	}

	public LiveScore getLiveScore() {
		return liveScore;
	}

	public void setLiveScore(LiveScore liveScore) {
		this.liveScore = liveScore;
	}

	public ExtraRuns getExtraRuns() {
		return extraRuns;
	}

	public void setExtraRuns(ExtraRuns extraRuns) {
		this.extraRuns = extraRuns;
	}

	public Inning getInning() {
		return inning;
	}

	public void setInning(Inning inning) {
		this.inning = inning;
	}

	public Bowler getBowler() {
		return bowler;
	}

	public void setBowler(Bowler bowler) {
		this.bowler = bowler;
	}

	public Map<String, Batsmen> getBatsmens() {
		return batsmens;
	}

	public void setBatsmens(Map<String, Batsmen> batsmens) {
		this.batsmens = batsmens;
	}
	
}
