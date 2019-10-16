/**
 * 
 */
package com.aannya.cricplexheros.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aannya.cricplexheros.dto.BatsmanStatDto;
import com.aannya.cricplexheros.dto.BowlerStatDto;
import com.aannya.cricplexheros.dto.ChangePinDTO;
import com.aannya.cricplexheros.dto.FielderStatDto;
import com.aannya.cricplexheros.dto.FileStorageProperties;
import com.aannya.cricplexheros.dto.LoginDTO;
import com.aannya.cricplexheros.dto.PlayerProfileDto;
import com.aannya.cricplexheros.dto.ResponseDTO;
import com.aannya.cricplexheros.dto.UserDTO;
import com.aannya.cricplexheros.exception.ModelInsertionException;
import com.aannya.cricplexheros.scorecard.model.Team;
import com.aannya.cricplexheros.service.FileStorageService;
import com.aannya.cricplexheros.service.UserService;
import com.aannya.cricplexheros.user.model.User;
import com.aannya.cricplexheros.util.ResponseStatusCode;

/**
 * @author Babban
 *
 */
@RestController
@RequestMapping("/api/user/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	FileStorageProperties fileStorageProperties;
	
	@Autowired
	FileStorageService fileStorageService;
	
	@PostMapping("create")
	public ResponseDTO create(@RequestParam(name = "profilePic", required = false) MultipartFile profilePic,@ModelAttribute UserDTO userDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> errors = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		String fileDownloadUri = null;
		
		if(!userService.isUserExist(userDTO.getMobileNumber())) {
			try {
				if(null != profilePic) {
					fileStorageService.storeFile(profilePic);
					fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
			                .path("/api/user/downloadFile/")
			                .path(profilePic.getOriginalFilename())
			                .toUriString();
					userDTO.setProfileImgPath(fileDownloadUri);
				} else {
					fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
			                .path("/api/user/downloadFile/")
			                .path("user_temp08072019.png")
			                .toUriString();
					userDTO.setProfileImgPath(fileDownloadUri);		
				}
				User user = userService.create(userDTO);
				if (user != null) {
					response.put("user_id", user.getUser_id());
					response.put("team_id", user.getTeam_id());
					response.put("name", user.getName());
					response.put("mobile_number", user.getMobile_number());
					response.put("profile_img_path", user.getProfile_img_Path());
					response.put("location", user.getLocation());
					response.put("email", user.getEmail());
					response.put("player_role", user.getPlayer_role());
					response.put("batting_style", user.getBatting_style());
					response.put("bowling_style", user.getBowling_style());
					response.put("dob", user.getDob());
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
			} catch (ModelInsertionException e) {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setErrors(errors);
				responseDTO.setMessage("Error while adding User.");
				responseDTO.setResponse(null);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} else {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setMessage("User alreday exists.");
			responseDTO.setErrors(errors);
			responseDTO.setResponse(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}
		
		return responseDTO;
	}
	@PostMapping("login")
	public ResponseDTO login(@RequestBody LoginDTO loginDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> errors = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		User user = null;
		user = userService.userAuthenticate(loginDTO);
		if(user != null) {
			try {				
				response.put("team_id", user.getTeam_id());
				response.put("name", user.getName());
				response.put("mobile_number", user.getMobile_number());
				response.put("profile_img_path", user.getProfile_img_Path());
				response.put("location", user.getLocation());
				response.put("email", user.getEmail());
				response.put("player_role", user.getPlayer_role());
				response.put("batting_style", user.getBatting_style());
				response.put("bowling_style", user.getBowling_style());
				response.put("dob", user.getDob());
					responseDTO.setResponse(response);
					responseDTO.setMessage("You are successfully logged in.");
					responseDTO.setErrors(null);
					responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
					responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
					responseDTO.setRequestSuccess(true);
				
			} catch (Exception e) {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setErrors(errors);
				responseDTO.setMessage("Error while trying to login.");
				responseDTO.setResponse(null);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} else {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setErrors(errors);
			responseDTO.setMessage("Error while trying to login.Incorrect mobile number/pin.");
			responseDTO.setResponse(null);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);		}
		
		return responseDTO;
	}
	
	@PostMapping("uploadpic")
	public ResponseDTO uploadpic(@RequestBody UserDTO userDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		
		
		return responseDTO;
	}
	@PostMapping("edit/{id}")
	public ResponseDTO edit(@RequestParam(name="profilePic", required=false) MultipartFile profilePic, @ModelAttribute UserDTO userDTO, @PathVariable String id) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> errors = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		String fileDownloadUri = null;
		
		User checkUser = userService.findById(Long.valueOf(id));
		if(checkUser != null) {
			try {
				if(null != profilePic) {
					fileStorageService.storeFile(profilePic);
					fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
			                .path("/api/user/downloadFile/")
			                .path(profilePic.getOriginalFilename())
			                .toUriString();
					userDTO.setProfileImgPath(fileDownloadUri);
				} 				
				User user = userService.update(id, userDTO);
				if (user != null) {
					response.put("user_id", user.getUser_id());
					response.put("team_id", user.getTeam_id());
					response.put("name", user.getName());
					response.put("mobile_number", user.getMobile_number());
					response.put("profile_img_path", user.getProfile_img_Path());
					response.put("location", user.getLocation());
					response.put("email", user.getEmail());
					response.put("player_role", user.getPlayer_role());
					response.put("batting_style", user.getBatting_style());
					response.put("bowling_style", user.getBowling_style());
						response.put("dob", user.getDob());
					responseDTO.setResponse(response);
					responseDTO.setMessage("User Updated Successfully.");
					responseDTO.setErrors(null);
					responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
					responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
					responseDTO.setRequestSuccess(true);
				} else {
					errors.put("server", "Service unavailable. Please try again!");
					responseDTO.setErrors(errors);
					responseDTO.setMessage("Error while updating User.");
					responseDTO.setResponse(null);
					responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
					responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
					responseDTO.setRequestSuccess(false);
				}
			
			} catch (Exception e) {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setErrors(errors);
				responseDTO.setMessage("Error while updating User.");
				responseDTO.setResponse(null);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} else {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setResponse(null);
			responseDTO.setMessage("User does not exist.");
			responseDTO.setErrors(errors);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
		}
		
		
		return responseDTO;
	}
	@PostMapping("resetpin")
	public ResponseDTO resetpin(@RequestBody ChangePinDTO dto) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> errors = new HashMap<>();

		boolean checkUser = userService.isUserExist(dto.getMobileNumber());
		if(checkUser) {
			if (userService.changePin(dto)) {
				responseDTO.setMessage("Pin changed Successfully.");
				responseDTO.setErrors(null);
				responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
				responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
				responseDTO.setRequestSuccess(true);
			} else {
				errors.put("server", "Service unavailable. Please try again!");
				responseDTO.setResponse(null);
				responseDTO.setMessage("Error while resetting the pin.");
				responseDTO.setErrors(errors);
				responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
				responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
				responseDTO.setRequestSuccess(false);
			}
		} else {
			errors.put("server", "Service unavailable. Please try again!");
			responseDTO.setResponse(null);
			responseDTO.setMessage("User does not exist.");
			responseDTO.setErrors(errors);
			responseDTO.setResponseCode(ResponseStatusCode.SERVER_UNAVAILABLE_CODE);
			responseDTO.setResponseText(ResponseStatusCode.SERVER_UNAVAILABLE_TEXT);
			responseDTO.setRequestSuccess(false);
	}
		return responseDTO;
	}
	@PostMapping("forgotpin")
	public ResponseDTO forgotpin(@RequestBody UserDTO userDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		
		
		return responseDTO;
	}
	@GetMapping("{userId}/stats")
	public ResponseDTO getStats(@PathVariable("userId") String userId) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
			
		PlayerProfileDto playerProfileDto = userService.playerStat(userId);
		
		if(null != playerProfileDto) {
			response.put("bowling_stats", playerProfileDto.getBowlingStat());
			response.put("batting_stats",playerProfileDto.getBattingStat());
			response.put("fielding_stats",playerProfileDto.getFieldingStat());
			response.put("profile", playerProfileDto.getUserDTO());
			
		}		
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		
		return responseDTO;
	}
	
	@GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

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
	@GetMapping("searchplayer")
	public ResponseDTO searchPlayers(@RequestParam("searchString") String searchString) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		
		List<User> players = userService.getListOfAllPLayers(searchString);
		
		response.put("players", players);
		responseDTO.setResponse(response);
		responseDTO.setErrors(null);
		responseDTO.setResponseCode(ResponseStatusCode.OK_CODE);
		responseDTO.setResponseText(ResponseStatusCode.OK_TEXT);
		responseDTO.setRequestSuccess(true);
		return responseDTO;
	}
	
	@PostMapping("addplayer")
	public ResponseDTO addPlayers(@RequestParam("mobileNumber") String mobileNumber, @RequestParam("teamId") String teamId) {
		ResponseDTO responseDTO = new ResponseDTO();
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> errors = new HashMap<>();
		
		User user = userService.addPlayerToTeam(mobileNumber, teamId);
		
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
	}
}
