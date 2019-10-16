/**
 * 
 */
package com.aannya.cricplexheros.service;

import java.util.List;

import com.aannya.cricplexheros.dto.LiveScoreDTO;
import com.aannya.cricplexheros.dto.ScorecardDTO;
import com.aannya.cricplexheros.dto.UndoDTO;
import com.aannya.cricplexheros.scorecard.model.Batsmen;
import com.aannya.cricplexheros.scorecard.model.Bowler;
import com.aannya.cricplexheros.scorecard.model.LiveScore;

/**
 * @author Babban
 *
 */
public interface LiveScoreService {
	
	boolean addLiveScore(LiveScoreDTO liveScoreDTO);
	
	boolean undo(UndoDTO undoDTO);
	
	ScorecardDTO scorecard(String matchId);
	
	List<Batsmen> batsmenList(String matchId, int inningNumber);
	
	List<Bowler> bowlerList(String matchId, int inningNumber);
	
	boolean checkRandomNum(String matchId, long randomNumber);
	
}
