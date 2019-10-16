/**
 * 
 */
package com.aannya.cricplexheros.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aannya.cricplexheros.dto.LiveScoreDTO;
import com.aannya.cricplexheros.dto.ResponseDTO;
import com.aannya.cricplexheros.dto.ScorecardDTO;
import com.aannya.cricplexheros.dto.UndoDTO;
import com.aannya.cricplexheros.scorecard.model.Scorer;
import com.aannya.cricplexheros.scorecard.repository.BatsmenRepository;
import com.aannya.cricplexheros.scorecard.repository.BowlerRepository;
import com.aannya.cricplexheros.scorecard.repository.ExtraRunRepository;
import com.aannya.cricplexheros.scorecard.repository.InningRepository;
import com.aannya.cricplexheros.scorecard.repository.LiveScoreRepository;
import com.aannya.cricplexheros.scorecard.repository.ScorerRepository;
import com.aannya.cricplexheros.service.LiveScoreService;
import com.aannya.cricplexheros.service.UserService;
import com.aannya.cricplexheros.util.ResponseStatusCode;

/**
 * @author Babban
 *
 */
@RestController
@RequestMapping("/api/live/")
public class LiveScoreController {
	
	@Autowired
	LiveScoreService liveScoreService;
	
	@Autowired
	InningRepository inningRepository;
	
	@Autowired
	LiveScoreRepository liveScoreRepository;
	
	@Autowired
	ExtraRunRepository extraRunRepository;
	
	@Autowired
	BatsmenRepository batsmenRepository;
	
	@Autowired
	BowlerRepository bowlerRepository;
	
	@Autowired
	ScorerRepository scorerRepository;
	
	@Autowired
	UserService userService;
	
	@PostMapping("addscore") 
	public ResponseDTO addScore(@RequestBody LiveScoreDTO liveScoreDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> errors = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		
		try {
			//Scorer scorer = scorerRepository.findScorer(liveScoreDTO.getMatchId());
			//if(null != scorer && scorer.getUserId().equalsIgnoreCase(liveScoreDTO.getUserId()) && scorer.getDeviceId().equalsIgnoreCase(liveScoreDTO.getDeviceId())) {
				if(!liveScoreService.checkRandomNum(liveScoreDTO.getMatchId(), liveScoreDTO.getRandomNumber())) {
					boolean scoreResult = liveScoreService.addLiveScore(liveScoreDTO);
					
					if(scoreResult) {
						
						responseDTO.setResponse(response);
						responseDTO.setMessage("Score added Successfully.");
						responseDTO.setErrors(null);
						responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
						responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
						responseDTO.setRequestSuccess(true);
						
					}else {
						errors.put("server", "Service unavailable. Please try again!");
						responseDTO.setErrors(errors);
						responseDTO.setMessage("Error while adding adding score.");
						responseDTO.setResponse(null);
						responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
						responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
						responseDTO.setRequestSuccess(false);
					}
				} else {
					errors.put("server", "Service unavailable. Please try again!");
					responseDTO.setErrors(errors);
					responseDTO.setMessage("Duplicate Random number");
					responseDTO.setResponse(null);
					responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
					responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
					responseDTO.setRequestSuccess(false);
				}

			/*
			 * } else { User user = userService.findById(Long.valueOf(scorer.getUserId()));
			 * 
			 * errors.put("server", "Error while choosing scorer");
			 * responseDTO.setErrors(errors); responseDTO.setMessage(user.getName()
			 * +" is already scoring this match on device: "+scorer.getDeviceId()
			 * +". Please ask him to delegate you first to start scoring in your device");
			 * responseDTO.setResponse(null);
			 * responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			 * responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			 * responseDTO.setRequestSuccess(false); }
			 */
			
			
		} catch (Exception e) {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setErrors(errors);
			responseDTO.setMessage("Error while adding score.");
			responseDTO.setResponse(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}		
		
		
		return responseDTO;
	}
	@PostMapping("undo") 
	public ResponseDTO addScore(@RequestBody UndoDTO undoDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> errors = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		
		try {

			boolean scoreResult = liveScoreService.undo(undoDTO);
			
			if(scoreResult) {
				
				responseDTO.setResponse(response);
				responseDTO.setMessage("Score removed Successfully.");
				responseDTO.setErrors(null);
				responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
				responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
				responseDTO.setRequestSuccess(true);
				
			}else {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setErrors(errors);
				responseDTO.setMessage("Error while removing score.");
				responseDTO.setResponse(null);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} catch (Exception e) {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setErrors(errors);
			responseDTO.setMessage("Error while removing score.");
			responseDTO.setResponse(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}		
		
		
		return responseDTO;
	}
	@GetMapping("scorecard/{matchId}")
	public ResponseDTO scorecard(@PathVariable("matchId") String matchId) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> errors = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			ScorecardDTO scorecardResult = liveScoreService.scorecard(matchId);
			
			if(scorecardResult != null) {				
				response.put("status", scorecardResult.getStatus());
				response.put("match_result", scorecardResult.getMatchResult());
				response.put("inning_one_score", scorecardResult.getFirstInningScore());
				response.put("inning_two_score", scorecardResult.getSecondInningScore());
				response.put("inning_one", scorecardResult.getInningOne());
				response.put("inning_two", scorecardResult.getInningTwo());
				response.put("inning_one_batsmen", scorecardResult.getFirstInningBatsmen());
				response.put("inning_two_batsmen", scorecardResult.getSecondInningBatsmen());
				response.put("inning_one_bowler", scorecardResult.getFirstInningBowler());
				response.put("inning_two_bowler", scorecardResult.getSecondInningBowler());
				response.put("inning_one_extra", scorecardResult.getExtraRunsInningOne());
				response.put("inning_two_extra", scorecardResult.getExtraRunsInningTwo());
				
				responseDTO.setResponse(response);
				responseDTO.setErrors(null);
				responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
				responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
				responseDTO.setRequestSuccess(true);
				
			}else {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setErrors(errors);
				responseDTO.setMessage("Error while getting scorecard.");
				responseDTO.setResponse(null);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} catch (Exception e) {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setErrors(errors);
			responseDTO.setMessage("Error while getting scorecard.");
			responseDTO.setResponse(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}		
		
		
		return responseDTO;
	}
	
	
}
