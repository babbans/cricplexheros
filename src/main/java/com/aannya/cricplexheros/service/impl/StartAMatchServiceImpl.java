/**
 * 
 */
package com.aannya.cricplexheros.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aannya.cricplexheros.dto.MatchStatusDTO;
import com.aannya.cricplexheros.dto.ScorecardDTO;
import com.aannya.cricplexheros.dto.ScorerDto;
import com.aannya.cricplexheros.dto.StartMatchDTO;
import com.aannya.cricplexheros.scorecard.model.PointTable;
import com.aannya.cricplexheros.scorecard.model.Scorer;
import com.aannya.cricplexheros.scorecard.model.Squad;
import com.aannya.cricplexheros.scorecard.model.StartAMatch;
import com.aannya.cricplexheros.scorecard.model.Team;
import com.aannya.cricplexheros.scorecard.repository.ScorerRepository;
import com.aannya.cricplexheros.scorecard.repository.StartAMatchRepository;
import com.aannya.cricplexheros.scorecard.repository.TeamRepository;
import com.aannya.cricplexheros.service.StartAMatchService;
import com.aannya.cricplexheros.service.TeamService;

/**
 * @author Babban
 *
 */
@Service
public class StartAMatchServiceImpl implements StartAMatchService{
	
	@Autowired
	StartAMatchRepository startAMatchRepository;
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	ScorerRepository scorerRepository;
	
	@Override
	public StartAMatch create(StartMatchDTO dto) {
		
		StartAMatch startAMatch  = new StartAMatch();
		Team a = teamService.findById(Long.valueOf(dto.getTeamaId()));
		Team b = teamService.findById(Long.valueOf(dto.getTeambId()));
		
		startAMatch.setTeama_logo(a.getLogoImgPath());
		startAMatch.setTeama_name(a.getName());
		startAMatch.setTeamb_logo(b.getLogoImgPath());
		startAMatch.setTeamb_name(b.getName());
		
		startAMatch.setUserId(dto.getUserId());
		startAMatch.setTournamentId(dto.getTournamentId());
		startAMatch.setTeama_id(dto.getTeamaId());
		startAMatch.setTeamb_id(dto.getTeambId());
		startAMatch.setTossResult(dto.getTossResult());
		startAMatch.setMatchType(dto.getMatchType());
		startAMatch.setNoOfOver(dto.getNoOfOver());
		startAMatch.setGroundLocation(dto.getGroundLocation());
		startAMatch.setDatetime(dto.getDatetime());
		startAMatch.setBallType(dto.getBallType());
		startAMatch.setCountNoBallRun(dto.getCountNoBallRun());
		startAMatch.setElectedToBat(dto.getElectedToBat());
		startAMatch.setStrikerBatsman_id(String.valueOf(dto.getStrikerBatsman_id()));
		startAMatch.setNonstrikerBatsman_id(String.valueOf(dto.getNonstrikerBatsman_id()));
		startAMatch.setBowler_id(String.valueOf(dto.getBowler_id()));
		startAMatch.setPlayingElevenTeamaCount(dto.getPlayingElevenTeama().size());
		startAMatch.setPlayingElevenTeambCount(dto.getPlayingElevenTeamb().size());
		startAMatch.setTeamaCaptain_id(String.valueOf(dto.getTeamaCaptain_id()));
		startAMatch.setTeamaWicketKeeper_id(String.valueOf(dto.getTeamaWicketKeeper_id()));
		startAMatch.setTeambCaptain_id(String.valueOf(dto.getTeambCaptain_id()));
		startAMatch.setTeambWicketKeeper_id(String.valueOf(dto.getTeambWicketKeeper_id()));
		
		Set<Squad> squad = new HashSet<>();
		
		if(a.getName().equalsIgnoreCase(dto.getElectedToBat())) {
			
			for (String playerId : dto.getPlayingElevenTeama()) {
				Squad sq = new Squad();
				sq.setBattingTeam(true);
				sq.setPlayerId(playerId);
				sq.setTeamId(a.getId());
				sq.setTeamName(a.getName());
				sq.setTournamentId(dto.getTournamentId());
				sq.setMatch(startAMatch);
				squad.add(sq);
			}
			for (String playerId : dto.getPlayingElevenTeamb()) {
				Squad sq = new Squad();
				sq.setBattingTeam(false);
				sq.setPlayerId(playerId);
				sq.setTeamId(b.getId());
				sq.setTeamName(b.getName());
				sq.setTournamentId(dto.getTournamentId());
				sq.setMatch(startAMatch);
				squad.add(sq);
			}
			
		} else {
			for (String playerId : dto.getPlayingElevenTeama()) {
				Squad sq = new Squad();
				sq.setBattingTeam(false);
				sq.setPlayerId(playerId);
				sq.setTeamId(a.getId());
				sq.setTeamName(a.getName());
				sq.setTournamentId(dto.getTournamentId());
				sq.setMatch(startAMatch);
				squad.add(sq);
			}
			for (String playerId : dto.getPlayingElevenTeamb()) {
				Squad sq = new Squad();
				sq.setBattingTeam(true);
				sq.setPlayerId(playerId);
				sq.setTeamId(b.getId());
				sq.setTeamName(b.getName());
				sq.setTournamentId(dto.getTournamentId());
				sq.setMatch(startAMatch);
				squad.add(sq);
			}
	
		}
		startAMatch.setSquad(squad);
		
		//insert into scorer
		/*
		 * Scorer scorer = new Scorer(); scorer.setDeviceId(dto.getDeviceId());
		 * scorer.setMatch(startAMatch); scorer.setUserId(dto.getUserId());
		 * scorer.setActive(true);
		 */	
		StartAMatch result = startAMatchRepository.save(startAMatch);
	//	scorerRepository.save(scorer);
		
		return result;
	}

	@Override
	public List<StartAMatch> findAll() {
		List<StartAMatch> matches = new ArrayList<>();
		matches = startAMatchRepository.findAll();
		
		  DateTimeFormatter formatter =
		  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		  Collections.sort(matches, (s1, s2) -> LocalDateTime.parse(s2.getDatetime(),
		  formatter). compareTo(LocalDateTime.parse(s1.getDatetime(), formatter)));
		  
	return matches;
	
	}

	@Override
	public List<StartAMatch> findByUserId(String userId) {
		List<StartAMatch> matches = new ArrayList<>();
		matches = startAMatchRepository.findByUserId(userId);
		
		  DateTimeFormatter formatter =
		  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		  Collections.sort(matches, (s1, s2) -> LocalDateTime.parse(s2.getDatetime(),
		  formatter). compareTo(LocalDateTime.parse(s1.getDatetime(), formatter)));
		  
	return matches;
		
	}
	
	@Override
	public List<StartAMatch> findByTournamentId(String tournamentId) {
		List<StartAMatch> matches = new ArrayList<>();
		matches = startAMatchRepository.findByTournamentId(tournamentId);
		
		  DateTimeFormatter formatter =
		  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		  Collections.sort(matches, (s1, s2) -> LocalDateTime.parse(s2.getDatetime(),
		  formatter). compareTo(LocalDateTime.parse(s1.getDatetime(), formatter)));
		 	return matches;
		 	/*
			 * DateTimeFormatter formatter =
			 * DateTimeFormatter.ofPattern("E,MMM d yyyy hh:mm a"); DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
			 * Collections.sort(matches, (s1, s2) -> LocalDateTime.parse(s2.getDatetime(),2019-09-01 19:00
			 * formatter). compareTo(LocalDateTime.parse(s1.getDatetime(), formatter)));
			 */	
	}

	@Override
	public boolean updateMatchStatus(MatchStatusDTO matchStatusDTO) {
		boolean result = false;
		Optional<StartAMatch> isMatchPresent = startAMatchRepository.findById(Long.valueOf(matchStatusDTO.getMatchId()));
		if(isMatchPresent.isPresent()) {
			StartAMatch match = isMatchPresent.get();
			try {
				match.setMatchResult(matchStatusDTO.getMatchResult());
				startAMatchRepository.save(match);
				result = true;
			} catch (Exception e) {
				System.out.println("Exception occured while updating match status.");
			}
		}
		return result;
	}

	@Override
	public List<StartAMatch> getListOfSearchedMatches(String searchString) {
		
		return startAMatchRepository.getListOfSearchedMatches(searchString);
	}

	@Override
	public StartAMatch findById(long id) {
		StartAMatch match = null;
		Optional<StartAMatch> findMatch = startAMatchRepository.findById(id);
		if(findMatch.isPresent())
			match = findMatch.get();
		return match;
	}

	@Override
	public boolean addScorer(ScorerDto dto) {
		/*
		 * Optional<StartAMatch> match =
		 * startAMatchRepository.findById(Long.valueOf(dto.getMatchId()));
		 * if(match.isPresent()) {
		 * scorerRepository.updateScorer(String.valueOf(match.get().getId())); Scorer
		 * scorer = new Scorer(); scorer.setActive(true);
		 * scorer.setDeviceId(dto.getDeviceId()); scorer.setMatch(match.get());
		 * scorer.setUserId(dto.getUserId());
		 * 
		 * scorerRepository.save(scorer); return true; }
		 */
		return false;
	}
	
}
