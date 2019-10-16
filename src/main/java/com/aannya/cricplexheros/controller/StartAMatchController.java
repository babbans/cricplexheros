
/**
 * 
 */
package com.aannya.cricplexheros.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aannya.cricplexheros.dto.MatchStatusDTO;
import com.aannya.cricplexheros.dto.ResponseDTO;
import com.aannya.cricplexheros.dto.ScorecardDTO;
import com.aannya.cricplexheros.dto.ScorerDto;
import com.aannya.cricplexheros.dto.StartMatchDTO;
import com.aannya.cricplexheros.scorecard.model.Squad;
import com.aannya.cricplexheros.scorecard.model.StartAMatch;
import com.aannya.cricplexheros.scorecard.model.Team;
import com.aannya.cricplexheros.service.StartAMatchService;
import com.aannya.cricplexheros.service.TeamService;
import com.aannya.cricplexheros.service.UserService;
import com.aannya.cricplexheros.user.model.User;
import com.aannya.cricplexheros.util.ResponseStatusCode;

/**
 * @author Babban
 *
 */
@RestController
@RequestMapping("/api/startmatch/")
public class StartAMatchController {
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	StartAMatchService startAMatchService;
	
	@PostMapping("add")
	public ResponseDTO startMatch(@RequestBody StartMatchDTO startMatchDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> errors = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		List<User> battingTeamPlayingEleven = new ArrayList<>();
		List<User> bowlingTeamPlayingEleven = new ArrayList<>();
		StartAMatch startAMatch = startAMatchService.create(startMatchDTO);
		try {
			if(startAMatch != null) {
				response.put("user_id", startAMatch.getUserId());
				response.put("start_a_match_id", startAMatch.getId());
				Team selectWinningTeam = teamService.findById(Long.valueOf(startAMatch.getTeama_id()));
				if(selectWinningTeam.getName().equalsIgnoreCase((startAMatch.getElectedToBat()))) {
					response.put("batting_team", selectWinningTeam);
					response.put("fielding_team", teamService.findById(Long.valueOf(startAMatch.getTeamb_id())));
					
					
					  //response.put("batting_captain", userService.findById(Long.valueOf(startAMatch.getTeamaCaptain_id())));
					  response.put("batting_wicketkeeper", userService.findById(Long.valueOf(startAMatch.getTeamaWicketKeeper_id())));
					  //response.put("bowling_captain", userService.findById(Long.valueOf(startAMatch.getTeambCaptain_id())));
					  response.put("bowling_wicketkeeper", userService.findById(Long.valueOf(startAMatch.getTeambWicketKeeper_id())));
					 
					
				} else {
					response.put("batting_team", teamService.findById(Long.valueOf(startAMatch.getTeamb_id())));
					response.put("fielding_team", selectWinningTeam);
					
					 // response.put("batting_captain", userService.findById(Long.valueOf(startAMatch.getTeambCaptain_id())));
					  response.put("batting_wicketkeeper", userService.findById(Long.valueOf(startAMatch.getTeambWicketKeeper_id())));
					 // response.put("bowling_captain", userService.findById(Long.valueOf(startAMatch.getTeamaCaptain_id())));
					  response.put("bowling_wicketkeeper",userService.findById(Long.valueOf(startAMatch.getTeamaWicketKeeper_id())));
					 
				}
				
				response.put("toss_result", startAMatch.getTossResult());
				response.put("match_type", startAMatch.getMatchType());
				response.put("no_of_overs", startAMatch.getNoOfOver());
				response.put("ground_location", startAMatch.getGroundLocation());
				response.put("datetime", startAMatch.getDatetime());
				response.put("ball_type", startAMatch.getBallType());
				response.put("count_no_ball_run", startAMatch.getCountNoBallRun());
				response.put("elected_to_bat", startAMatch.getElectedToBat());
				response.put("striker_batsman", userService.findById(Long.valueOf(startAMatch.getStrikerBatsman_id())));
				response.put("non_striker_batsman", userService.findById(Long.valueOf(startAMatch.getNonstrikerBatsman_id())));
				response.put("bowler", userService.findById(Long.valueOf(startAMatch.getBowler_id())));
				
				/*
				 * for (String id : startMatchDTO.getPlayingElevenTeama()) { if(null !=
				 * userService.findById(Long.valueOf(id))) {
				 * teamaPlayingEleven.add(userService.findById(Long.valueOf(id))); }
				 * 
				 * } for (String id : startMatchDTO.getPlayingElevenTeamb()) { if(null !=
				 * userService.findById(Long.valueOf(id))) {
				 * teambPlayingEleven.add(userService.findById(Long.valueOf(id))); } }
				 * if(selectWinningTeam.getName().equalsIgnoreCase((startAMatch.getElectedToBat(
				 * )))) { response.put("batting_team_playing_eleven", teamaPlayingEleven);
				 * response.put("fielding_team_playing_eleven", teambPlayingEleven); } else {
				 * response.put("batting_team_playing_eleven", teambPlayingEleven);
				 * response.put("fielding_team_playing_eleven", teamaPlayingEleven); }
				 */
				
				/*
				 * for (Squad squad : startAMatch.getSquad()) { if(squad.isBattingTeam()) {
				 * battingTeamPlayingEleven.add(userService.findById(Long.valueOf(squad.
				 * getPlayerId()))); } else {
				 * bowlingTeamPlayingEleven.add(userService.findById(Long.valueOf(squad.
				 * getPlayerId()))); } } response.put("batting_team_playing_eleven",
				 * battingTeamPlayingEleven); response.put("fielding_team_playing_eleven",
				 * bowlingTeamPlayingEleven);
				 */	
				
				List<Long> bat = new ArrayList<>();
				List<Long> bowl = new ArrayList<>();
				for (Squad squad : startAMatch.getSquad()) {
					if(squad.isBattingTeam()) {
						bat.add(Long.valueOf(squad.getPlayerId()));
						//battingTeamPlayingEleven.add(userService.findById(Long.valueOf(squad.getPlayerId())));
					} else {
						bowl.add(Long.valueOf(squad.getPlayerId()));
						//bowlingTeamPlayingEleven.add(userService.findById(Long.valueOf(squad.getPlayerId())));
					}
				}
				//response.put("batting_team_playing_eleven", battingTeamPlayingEleven);
				//response.put("fielding_team_playing_eleven", bowlingTeamPlayingEleven);
				
				response.put("batting_team_playing_eleven", userService.findByUserUserIdIn(bat));
				response.put("fielding_team_playing_eleven", userService.findByUserUserIdIn(bowl));
		
				responseDTO.setResponse(response);
				responseDTO.setMessage("Start a match added Successfully.");
				responseDTO.setErrors(null);
				responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
				responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
				responseDTO.setRequestSuccess(true);
			}
			else {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setErrors(errors);
				responseDTO.setMessage("Error while adding Start a match.");
				responseDTO.setResponse(null);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} catch (Exception e) {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setErrors(errors);
			responseDTO.setMessage("Error while adding Start a match.");
			responseDTO.setResponse(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}
		
		
		return responseDTO;
	}
	@GetMapping("{matchId}/resume")
	public ResponseDTO startMatch(@PathVariable("matchId") String matchId) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> errors = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		List<User> battingTeamPlayingEleven = new ArrayList<>();
		List<User> bowlingTeamPlayingEleven = new ArrayList<>();
		StartAMatch startAMatch = startAMatchService.findById(Long.valueOf(matchId));
		try {
			if(startAMatch != null) {
				response.put("user_id", startAMatch.getUserId());
				response.put("start_a_match_id", startAMatch.getId());
				Team selectWinningTeam = teamService.findById(Long.valueOf(startAMatch.getTeama_id()));
				if(selectWinningTeam.getName().equalsIgnoreCase((startAMatch.getElectedToBat()))) {
					response.put("batting_team", selectWinningTeam);
					response.put("fielding_team", teamService.findById(Long.valueOf(startAMatch.getTeamb_id())));
					
					//  response.put("batting_captain", userService.findById(Long.valueOf(startAMatch.getTeamaCaptain_id())));
					  response.put("batting_wicketkeeper", userService.findById(Long.valueOf(startAMatch.getTeamaWicketKeeper_id())));
					  //response.put("bowling_captain", userService.findById(Long.valueOf(startAMatch.getTeambCaptain_id())));
					  response.put("bowling_wicketkeeper", userService.findById(Long.valueOf(startAMatch.getTeambWicketKeeper_id())));
					 
					
				} else {
					response.put("batting_team", teamService.findById(Long.valueOf(startAMatch.getTeamb_id())));
					response.put("fielding_team", selectWinningTeam);
					
					 // response.put("batting_captain", userService.findById(Long.valueOf(startAMatch.getTeambCaptain_id())));
					  response.put("batting_wicketkeeper", userService.findById(Long.valueOf(startAMatch.getTeambWicketKeeper_id())));
					 // response.put("bowling_captain", userService.findById(Long.valueOf(startAMatch.getTeamaCaptain_id())));
					  response.put("bowling_wicketkeeper",userService.findById(Long.valueOf(startAMatch.getTeamaWicketKeeper_id())));
					 
				}
				
				response.put("toss_result", startAMatch.getTossResult());
				response.put("match_type", startAMatch.getMatchType());
				response.put("no_of_overs", startAMatch.getNoOfOver());
				response.put("ground_location", startAMatch.getGroundLocation());
				response.put("datetime", startAMatch.getDatetime());
				response.put("ball_type", startAMatch.getBallType());
				response.put("count_no_ball_run", startAMatch.getCountNoBallRun());
				response.put("elected_to_bat", startAMatch.getElectedToBat());
				response.put("striker_batsman", userService.findById(Long.valueOf(startAMatch.getStrikerBatsman_id())));
				response.put("non_striker_batsman", userService.findById(Long.valueOf(startAMatch.getNonstrikerBatsman_id())));
				response.put("bowler", userService.findById(Long.valueOf(startAMatch.getBowler_id())));
				
				List<Long> bat = new ArrayList<>();
				List<Long> bowl = new ArrayList<>();
				for (Squad squad : startAMatch.getSquad()) {
					if(squad.isBattingTeam()) {
						bat.add(Long.valueOf(squad.getPlayerId()));
						//battingTeamPlayingEleven.add(userService.findById(Long.valueOf(squad.getPlayerId())));
					} else {
						bowl.add(Long.valueOf(squad.getPlayerId()));
						//bowlingTeamPlayingEleven.add(userService.findById(Long.valueOf(squad.getPlayerId())));
					}
				}
				//response.put("batting_team_playing_eleven", battingTeamPlayingEleven);
				//response.put("fielding_team_playing_eleven", bowlingTeamPlayingEleven);
				
				response.put("batting_team_playing_eleven", userService.findByUserUserIdIn(bat));
				response.put("fielding_team_playing_eleven", userService.findByUserUserIdIn(bowl));
				
				responseDTO.setResponse(response);
				responseDTO.setMessage("Match Resumed Successfully.");
				responseDTO.setErrors(null);
				responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
				responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
				responseDTO.setRequestSuccess(true);
			}
			else {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setErrors(errors);
				responseDTO.setMessage("Error while resuming the match.");
				responseDTO.setResponse(null);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} catch (Exception e) {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setErrors(errors);
			responseDTO.setMessage("Error while resuming the match.");
			responseDTO.setResponse(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}
		
		
		return responseDTO;
	}
	
	@GetMapping("/matches/{userId}") 
	public ResponseDTO getUserMatches(@PathVariable("userId") String userId) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		List<StartAMatch> matchList = startAMatchService.findByUserId(userId);
		
		response.put("matches", matchList);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	@GetMapping("/tournament/matches/{tournamentId}") 
	public ResponseDTO getTournamentMatches(@PathVariable("tournamentId") String tournamentId) {
		ResponseDTO responseDTO = new ResponseDTO();	
		Map<String, Object> response = new HashMap<>();
		
		List<StartAMatch> matchList = startAMatchService.findByTournamentId(tournamentId);
		
		response.put("matches", matchList);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	@PostMapping("/scorer") 
	public ResponseDTO createScorer(@RequestBody ScorerDto dto) {
		ResponseDTO responseDTO = new ResponseDTO();	
		Map<String, Object> errors = new HashMap<>();
		try {
			if(startAMatchService.addScorer(dto)) {
				responseDTO.setMessage("Scorer added Successfully.");
				responseDTO.setErrors(null);
				responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
				responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
				responseDTO.setRequestSuccess(true);
			}
			else {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setErrors(errors);
				responseDTO.setMessage("Error while adding scorer");
				responseDTO.setResponse(null);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} catch(Exception e) {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setErrors(errors);
			responseDTO.setMessage("Error while adding scorer");
			responseDTO.setResponse(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}
		
		return responseDTO;
	}
	
	@GetMapping("matches")
	public ResponseDTO getTournaments() {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		List<StartAMatch> matchList = startAMatchService.findAll();
		
		response.put("matches", matchList);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	@PostMapping("status") 
	public ResponseDTO getMatchStatus(@RequestBody MatchStatusDTO matchStatusDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		boolean result = startAMatchService.updateMatchStatus(matchStatusDTO);
		
		if(result) {
			responseDTO.setResponse(response);
			responseDTO.setErrors(null);
			responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
			responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
			responseDTO.setRequestSuccess(true);
		
		} else {
			responseDTO.setResponse(response);
			responseDTO.setErrors(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		
		}
		
		return responseDTO;

	}
	@GetMapping("searchmatch")
	public ResponseDTO searchMatches(@RequestParam("searchString") String searchString) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		List<StartAMatch> matches = startAMatchService.getListOfSearchedMatches(searchString);
		
		response.put("matches", matches);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		return responseDTO;
	}
	
}
