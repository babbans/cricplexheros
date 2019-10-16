/**
 * 
 */
package com.aannya.cricplexheros.service;

import java.util.List;

import com.aannya.cricplexheros.dto.BatsmanStatDto;
import com.aannya.cricplexheros.dto.BowlStatDto;
import com.aannya.cricplexheros.dto.ChangePinDTO;
import com.aannya.cricplexheros.dto.LoginDTO;
import com.aannya.cricplexheros.dto.PlayerProfileDto;
import com.aannya.cricplexheros.dto.UserDTO;
import com.aannya.cricplexheros.exception.ModelInsertionException;
import com.aannya.cricplexheros.exception.ModelUpdateFailedException;
import com.aannya.cricplexheros.exception.UserNotFoundException;
import com.aannya.cricplexheros.scorecard.model.Team;
import com.aannya.cricplexheros.user.model.User;

/**
 * @author Babban
 *
 */
public interface UserService {
	
	User create(UserDTO object) throws ModelInsertionException;

	User find(String id) throws UserNotFoundException;
	
	User findById(long id);

	//User findByMobileNumber(String mobileNumber) throws UserNotFoundException;

	User update(String id, UserDTO object) throws ModelUpdateFailedException;

	boolean delete(Long userId);

	boolean forgotPin(String mobileNumber);
	
	String changePin (User user, ChangePinDTO changePinDTO);
	
	User userAuthenticate(LoginDTO loginDto); 
    
	boolean isUserExist(String mobileNumber);
	
	List<User> findByUserId(String teamId);
	
	boolean changePin (ChangePinDTO changePinDTO);
	
	PlayerProfileDto playerStat(String id);
	
	List<User> findByUserUserIdIn(List<Long> userIdList);
	
	User addPlayerToTeam(String mobileNumber, String teamId);
	
	List<User> getListOfAllPLayers(String searchString);
	
	List<User> findByTournamentId(String tournamentId);
	
}
