/**
 * 
 */
package com.aannya.cricplexheros.service;

import java.util.List;

import com.aannya.cricplexheros.dto.MatchStatusDTO;
import com.aannya.cricplexheros.dto.ScorecardDTO;
import com.aannya.cricplexheros.dto.ScorerDto;
import com.aannya.cricplexheros.dto.StartMatchDTO;
import com.aannya.cricplexheros.scorecard.model.StartAMatch;

/**
 * @author Babban
 *
 */
public interface StartAMatchService {
	
	StartAMatch create(StartMatchDTO startMatchDTO);
	
	List<StartAMatch> findAll();
	
	List<StartAMatch> findByUserId(String userId);
	
	List<StartAMatch> findByTournamentId(String tournamentId);
	
	boolean updateMatchStatus(MatchStatusDTO matchStatusDTO);
	
	List<StartAMatch> getListOfSearchedMatches(String searchString);
	
	StartAMatch findById(long id);
	
	boolean addScorer(ScorerDto dto);
}
