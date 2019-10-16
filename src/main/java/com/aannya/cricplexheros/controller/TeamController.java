/**
 * 
 */
package com.aannya.cricplexheros.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aannya.cricplexheros.dto.FileStorageProperties;
import com.aannya.cricplexheros.dto.ResponseDTO;
import com.aannya.cricplexheros.dto.TeamDTO;
import com.aannya.cricplexheros.exception.ModelInsertionException;
import com.aannya.cricplexheros.scorecard.model.Team;
import com.aannya.cricplexheros.scorecard.model.Tournament;
import com.aannya.cricplexheros.service.FileStorageService;
import com.aannya.cricplexheros.service.TeamService;
import com.aannya.cricplexheros.service.UserService;
import com.aannya.cricplexheros.user.model.User;
import com.aannya.cricplexheros.util.ResponseStatusCode;

/**
 * @author Babban
 *
 */
@RestController
@RequestMapping("/api/team/")
public class TeamController {
	@Autowired
	TeamService teamService;
	
	@Autowired
	UserService userService;
	
	
	@Autowired
	FileStorageProperties fileStorageProperties;
	
	@Autowired
	FileStorageService fileStorageService;
	
	@PostMapping("create")
	public ResponseDTO create(@RequestParam(name = "logo", required = false) MultipartFile logo,@ModelAttribute TeamDTO teamDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> errors = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		String fileDownloadUri = null;
		
		if(!teamService.isTeamExist(teamDTO.getName())) {
			try {
				if(logo != null) {
					fileStorageService.storeFile(logo);
					fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
			                .path("/api/user/downloadFile/")
			                .path(logo.getOriginalFilename())
			                .toUriString();
					teamDTO.setLogoImgPath(fileDownloadUri);
				} else {
					fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
			                .path("/api/user/downloadFile/")
			                .path("logo_temp08072019.png")
			                .toUriString();
					teamDTO.setLogoImgPath(fileDownloadUri);		
	
				}
				Team team = teamService.create(teamDTO);
				if (team != null) {
					response.put("team_id", team.getId());
					response.put("tournament_id", team.getTournamentId());
					response.put("name", team.getName());
					response.put("logo_img_path", team.getLogoImgPath());
					response.put("location", team.getLocation());
					responseDTO.setResponse(response);
					responseDTO.setMessage("Team added Successfully.");
					responseDTO.setErrors(null);
					responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
					responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
					responseDTO.setRequestSuccess(true);
				} else {
					errors.put("server", "Service unavailable. Please try again!");
					responseDTO.setErrors(errors);
					responseDTO.setMessage("Error while adding Team.");
					responseDTO.setResponse(null);
					responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
					responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
					responseDTO.setRequestSuccess(false);
				}
			} catch (ModelInsertionException e) {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setErrors(errors);
				responseDTO.setMessage("Error while adding Team.");
				responseDTO.setResponse(null);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} else {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setMessage("Team alreday exists.");
			responseDTO.setErrors(errors);
			responseDTO.setResponse(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}
		
		return responseDTO;
	}
	@GetMapping("{tournamentid}/teams") 
	public ResponseDTO getTournamentTeams(@PathVariable("tournamentid") String tournamentId) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		List<Team> teamList = teamService.findByTournamentId(tournamentId);
		
		response.put("teams", teamList);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	@GetMapping("/teams/{userId}") 
	public ResponseDTO getUserTeams(@PathVariable("userId") String userId) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		List<Team> teamList = teamService.findByUserId(userId);
		
		response.put("teams", teamList);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	
	@GetMapping("teams")
	public ResponseDTO getTournaments() {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		List<Team> teamList = teamService.findAll();
		
		response.put("teams", teamList);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	@GetMapping("team/{teamId}")
	public ResponseDTO getTeam(@PathVariable("teamId") String teamId) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		Team team = teamService.findById(Long.valueOf(teamId));
		
		response.put("team", team);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	
	@GetMapping("{teamId}/players") 
	public ResponseDTO getTeamPlayers(@PathVariable("teamId") String teamId) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		List<User> playerList = userService.findByUserId(teamId);
		
		response.put("players", playerList);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	/*@GetMapping("searchplayer")
	public ResponseDTO searchPlayers(@RequestParam("searchString") String searchString) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		List<User> players = teamService.getListOfAllPLayers(searchString);
		
		response.put("players", players);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		return responseDTO;
	}*/
	@GetMapping("searchteam")
	public ResponseDTO searchTeams(@RequestParam("searchString") String searchString) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		List<Team> teams = teamService.getListOfAllTeams(searchString);
		
		response.put("teams", teams);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		return responseDTO;
	}
	/*@PostMapping("addplayer")
	public ResponseDTO addPlayers(@RequestParam("mobileNumber") String mobileNumber, @RequestParam("teamId") String teamId) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> errors = new HashMap<>();
		
		User user = teamService.addPlayerToTeam(mobileNumber, teamId);
		
		if (user != null) {
			response.put("user", user);			
			responseDTO.setResponse(response);
			responseDTO.setMessage("User added Successfully.");
			responseDTO.setErrors(null);
			responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
			responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
			responseDTO.setRequestSuccess(true);
		} else {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setErrors(errors);
			responseDTO.setMessage("Error while adding User.");
			responseDTO.setResponse(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}
		return responseDTO;
	}*/
}
