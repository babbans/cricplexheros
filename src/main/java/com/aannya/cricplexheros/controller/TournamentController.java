/**
 * 
 */
package com.aannya.cricplexheros.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aannya.cricplexheros.dto.BatsmanStatDto;
import com.aannya.cricplexheros.dto.BowlerStatDto;
import com.aannya.cricplexheros.dto.FielderStatDto;
import com.aannya.cricplexheros.dto.FileStorageProperties;
import com.aannya.cricplexheros.dto.ResponseDTO;
import com.aannya.cricplexheros.dto.TournamentDTO;
import com.aannya.cricplexheros.exception.ModelInsertionException;
import com.aannya.cricplexheros.scorecard.model.PointTable;
import com.aannya.cricplexheros.scorecard.model.Tournament;
import com.aannya.cricplexheros.service.FileStorageService;
import com.aannya.cricplexheros.service.TournamentService;
import com.aannya.cricplexheros.util.ResponseStatusCode;

/**
 * @author Babban
 *
 */
@RestController
@RequestMapping("/api/tournament/")
public class TournamentController {
	@Autowired
	FileStorageProperties fileStorageProperties;
	
	@Autowired
	FileStorageService fileStorageService;
	
	@Autowired
	TournamentService tournamentService;
	
	@PostMapping("create")
	public ResponseDTO create(@RequestParam(name = "files", required = false) MultipartFile[] files, @ModelAttribute TournamentDTO tournamentDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> response = new LinkedHashMap<>();
		String bannerUri = null;
		String logoUri = null;
		
		if(!tournamentService.isTournamentExist(tournamentDTO.getTournamentName())) {
			try {
				if(files != null && files.length > 0) {
					if(files[0].getOriginalFilename() != null && files[0].getOriginalFilename().contains("_banner")) {
						bannerUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				                .path("/api/user/downloadFile/")
				                .path(files[0].getOriginalFilename())
				                .toUriString();
						logoUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				                .path("/api/user/downloadFile/")
				                .path(files[1].getOriginalFilename())
				                .toUriString();
					} else {
						bannerUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				                .path("/api/user/downloadFile/")
				                .path(files[1].getOriginalFilename())
				                .toUriString();
						logoUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				                .path("/api/user/downloadFile/")
				                .path(files[0].getOriginalFilename())
				                .toUriString();
					}
					fileStorageService.storeFile(files[0]);
					fileStorageService.storeFile(files[1]);						
					
				} 
				tournamentDTO.setBannerImgPath(bannerUri);
				tournamentDTO.setLogoImgPath(logoUri);
			
				Tournament tournament = tournamentService.create(tournamentDTO);
				if (tournament != null) {
					response.put("tournament_id", tournament.getId());
					response.put("banner_url", tournament.getBannerImgPath());
					response.put("logo_url", tournament.getLogoImgPath());
					response.put("tournament_name", tournament.getTournamentName());
					response.put("city", tournament.getCity());
					response.put("ground", tournament.getGround());
					response.put("organizer_name", tournament.getOrganizerName());
					response.put("organizer_number", tournament.getOrganizerNumber());
					response.put("allow_players_to_contact_for_registration", tournament.getAllowPlayersToConatctForRegistration());
					response.put("start_date", tournament.getStartDate());
					response.put("end_date", tournament.getEndDate());
					response.put("ball_type", tournament.getBowlType());
					response.put("match_type", tournament.getMatchType());
					responseDTO.setResponse(response);
					responseDTO.setMessage("Tournament added Successfully.");
					responseDTO.setErrors(null);
					responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
					responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
					responseDTO.setRequestSuccess(true);
				} else {
					errors.put("server", "Service unavailable. Please try again!");
					responseDTO.setMessage("Error while adding Tournament.");
					responseDTO.setErrors(errors);
					responseDTO.setResponse(response);
					responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
					responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
					responseDTO.setRequestSuccess(false);
				}
			} catch (ModelInsertionException e) {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setMessage("Error while adding Tournament.");
				responseDTO.setErrors(errors);
				responseDTO.setResponse(response);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} else {
			responseDTO.setMessage("Tournament alreday exists.");
			responseDTO.setErrors(errors);
			responseDTO.setResponse(response);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}
		
		return responseDTO;
	}
	@PostMapping("create1")
	public ResponseDTO create1(@RequestParam(name = "logo" , required = false) MultipartFile logo, @RequestParam(name = "banner", required = false) MultipartFile banner, @ModelAttribute TournamentDTO tournamentDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> errors = new LinkedHashMap<>();
		Map<String, Object> response = new LinkedHashMap<>();
		String bannerUri = null;
		String logoUri = null;
		
		if(!tournamentService.isTournamentExist(tournamentDTO.getTournamentName())) {
			try {
				if(banner != null) {
					fileStorageService.storeFile(banner);
					bannerUri = ServletUriComponentsBuilder.fromCurrentContextPath()
			                .path("/api/user/downloadFile/")
			                .path(banner.getOriginalFilename())
			                .toUriString();
				} 
				if(logo != null) {
					fileStorageService.storeFile(logo);	
					logoUri = ServletUriComponentsBuilder.fromCurrentContextPath()
			                .path("/api/user/downloadFile/")
			                .path(logo.getOriginalFilename())
			                .toUriString();
				} 			
				tournamentDTO.setBannerImgPath(bannerUri);
				tournamentDTO.setLogoImgPath(logoUri);
			
				Tournament tournament = tournamentService.create(tournamentDTO);
				if (tournament != null) {
					response.put("tournament_id", tournament.getId());
					response.put("banner_url", tournament.getBannerImgPath());
					response.put("logo_url", tournament.getLogoImgPath());
					response.put("tournament_name", tournament.getTournamentName());
					response.put("city", tournament.getCity());
					response.put("ground", tournament.getGround());
					response.put("organizer_name", tournament.getOrganizerName());
					response.put("organizer_number", tournament.getOrganizerNumber());
					response.put("allow_players_to_contact_for_registration", tournament.getAllowPlayersToConatctForRegistration());
					response.put("start_date", tournament.getStartDate());
					response.put("end_date", tournament.getEndDate());
					response.put("ball_type", tournament.getBowlType());
					response.put("match_type", tournament.getMatchType());
					responseDTO.setResponse(response);
					responseDTO.setMessage("Tournament added Successfully.");
					responseDTO.setErrors(null);
					responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
					responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
					responseDTO.setRequestSuccess(true);
				} else {
					errors.put("server", "Service unavailable. Please try again!");
					responseDTO.setMessage("Error while adding Tournament.");
					responseDTO.setErrors(errors);
					responseDTO.setResponse(null);
					responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
					responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
					responseDTO.setRequestSuccess(false);
				}
			} catch (ModelInsertionException e) {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setMessage("Error while adding Tournament.");
				responseDTO.setErrors(errors);
				responseDTO.setResponse(null);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} else {
			responseDTO.setMessage("Tournament alreday exists.");
			responseDTO.setErrors(errors);
			responseDTO.setResponse(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}
		
		return responseDTO;
	}

	@GetMapping("tournaments/{userId}")
	public ResponseDTO getTournamentsByUserId(@PathVariable("userId") String userId) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		List<Tournament> tournamentList = tournamentService.findByUserId(userId);
		
		response.put("tournaments", tournamentList);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	@GetMapping("tournaments")
	public ResponseDTO getTournaments() {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		List<Tournament> tournamentList = tournamentService.findAll();
		
		response.put("tournaments", tournamentList);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	@GetMapping("{tournamentId}/points-table")
	public ResponseDTO getPointsTable(@PathVariable("tournamentId") String tournamentId) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		List<PointTable> pointsTable = tournamentService.getPointsTable(tournamentId);
		
		response.put("pointsTable", pointsTable);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	@GetMapping("{tournamentId}/stats")
	public ResponseDTO getStats(@PathVariable("tournamentId") String tournamentId) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		
		List<BowlerStatDto> bowlerStats =  tournamentService.getBowlerStat(tournamentId);
		List<BatsmanStatDto>  batsmanStats = tournamentService.getBatsmanStat(tournamentId);
		List<FielderStatDto> fielderStat = tournamentService.getFinalFielderStat(tournamentId);	
		
		
		response.put("bowler_stats", bowlerStats);
		response.put("batsman_stats",batsmanStats);
		response.put("fielder_stats", fielderStat);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	@GetMapping("/countries")
	public ResponseDTO getCountries() {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		Set<String> countriesList = new HashSet<>();
		Set<String> countries = tournamentService.listFilesUsingJavaIO();
		String serverPath = "http://206.189.138.64:9090/cricplexheros/api/tournament/downloadFlag/";
		countries.forEach(e-> {
			countriesList.add(serverPath + e);
		});
		response.put("countries", countriesList);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	@GetMapping("/downloadFlag/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFlags(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
	
}
