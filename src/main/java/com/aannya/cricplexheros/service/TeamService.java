/**
 * 
 */
package com.aannya.cricplexheros.service;

import java.util.List;

import com.aannya.cricplexheros.dto.TeamDTO;
import com.aannya.cricplexheros.dto.TournamentDTO;
import com.aannya.cricplexheros.exception.ModelInsertionException;
import com.aannya.cricplexheros.exception.ModelUpdateFailedException;
import com.aannya.cricplexheros.exception.UserNotFoundException;
import com.aannya.cricplexheros.scorecard.model.Team;
import com.aannya.cricplexheros.user.model.User;

/**
 * @author Babban
 *
 */
public interface TeamService {
	Team create(TeamDTO object) throws ModelInsertionException;

	Team find(String id) throws UserNotFoundException;
	
	Team findById(long id);
	
	List<Team> findByTournamentId(String tournamentId);
	
	List<Team> findByUserId(String userId);
	
	List<Team> findAll();

	Team update(String id, TournamentDTO object) throws ModelUpdateFailedException;

	boolean delete(Long userId);

	boolean isTeamExist(String tournamentName);
	
	/*
	 * User addPlayerToTeam(String mobileNumber, String teamId);
	 * 
	 * List<User> getListOfAllPLayers(String searchString);
	 */	
	List<Team> getListOfAllTeams(String searchString);
}
