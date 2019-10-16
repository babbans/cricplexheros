/**
 * 
 */
package com.aannya.cricplexheros.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aannya.cricplexheros.dto.TeamDTO;
import com.aannya.cricplexheros.dto.TournamentDTO;
import com.aannya.cricplexheros.exception.ModelInsertionException;
import com.aannya.cricplexheros.exception.ModelUpdateFailedException;
import com.aannya.cricplexheros.exception.UserNotFoundException;
import com.aannya.cricplexheros.scorecard.model.Team;
import com.aannya.cricplexheros.user.model.User;
import com.aannya.cricplexheros.scorecard.repository.TeamRepository;
import com.aannya.cricplexheros.user.repository.UserRepository;
import com.aannya.cricplexheros.service.TeamService;

/**
 * @author Babban
 *
 */
@Service
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	TeamRepository teamRepository;
	
	/*
	 * @Autowired UserRepository userRepository;
	 */
	@Override
	public Team create(TeamDTO dto) throws ModelInsertionException {
		
		Team team = new Team();
		team.setLogoImgPath(dto.getLogoImgPath());
		team.setLocation(dto.getLocation());
		team.setName(dto.getName());
		team.setIsActive("Y");
		team.setCreationDate(new Date());
		team.setTournamentId(dto.getTournamentId());
		team.setUserId(dto.getUserId());
		
		return teamRepository.save(team);
	}

	@Override
	public Team find(String id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return teamRepository.getOne(Long.valueOf(id));
	}

	@Override
	public Team findById(long id) {
		
		Team team = null;
		Optional<Team> found = teamRepository.findById(id);
		if (found.isPresent()) {
			team = found.get();
		}
		return team;		
	}

	@Override
	public Team update(String id, TournamentDTO object) throws ModelUpdateFailedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTeamExist(String name) {
		boolean isTeamExists = false;
		if(teamRepository.isTeamExist(name)!= null)
			isTeamExists = true;
		
		return isTeamExists;
	}

	@Override
	public List<Team> findByTournamentId(String tournamentId) {
		List<Team> teamList = new ArrayList<>();
		teamList = teamRepository.findByTournamentId(tournamentId);
		return teamList;
	}

	@Override
	public List<Team> findByUserId(String userId) {
		List<Team> teamList = new ArrayList<>();
		teamList = teamRepository.findByUserId(userId);
		return teamList;
	}

	@Override
	public List<Team> findAll() {
		
		return teamRepository.findAll();
	}

	/*
	 * @Override public User addPlayerToTeam(String mobileNumber, String teamId) {
	 * User u = userRepository.isUsernameExist(mobileNumber); if(u != null) {
	 * u.setTeam_id(teamId); } return userRepository.save(u); }
	 * 
	 * @Override public List<User> getListOfAllPLayers(String searchString) {
	 * 
	 * return userRepository.getListOfAllPLayers(searchString); }
	 */

	@Override
	public List<Team> getListOfAllTeams(String searchString) {
		
		return teamRepository.getListOfAllTeams(searchString);
	}

}
