/**
 * 
 */
package com.aannya.cricplexheros.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aannya.cricplexheros.dto.BatmanStatDto;
import com.aannya.cricplexheros.dto.BatmanStatDtoFinal;
import com.aannya.cricplexheros.dto.BowlStatDto;
import com.aannya.cricplexheros.dto.ChangePinDTO;
import com.aannya.cricplexheros.dto.FielderStatDto;
import com.aannya.cricplexheros.dto.LoginDTO;
import com.aannya.cricplexheros.dto.PlayerProfileDto;
import com.aannya.cricplexheros.dto.UserDTO;
import com.aannya.cricplexheros.exception.ModelInsertionException;
import com.aannya.cricplexheros.exception.ModelUpdateFailedException;
import com.aannya.cricplexheros.exception.UserNotFoundException;
import com.aannya.cricplexheros.user.model.User;
import com.aannya.cricplexheros.scorecard.repository.BatsmenRepository;
import com.aannya.cricplexheros.scorecard.repository.BowlerRepository;
import com.aannya.cricplexheros.user.repository.UserRepository;
import com.aannya.cricplexheros.service.TournamentService;
import com.aannya.cricplexheros.service.UserService;

/**
 * @author Babban
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BatsmenRepository batsmanRepository;
	
	@Autowired
	BowlerRepository bowlerRepository;
	
	@Autowired
	TournamentService tournamentService;

	@Override
	public User create(UserDTO dto) throws ModelInsertionException {
		User user = new User();
		user.setName(dto.getName());
		user.setProfile_img_Path(dto.getProfileImgPath());
		user.setMobile_number(dto.getMobileNumber());
		user.setLocation(dto.getLocation());
		user.setPin(dto.getPin());
		user.setIs_active("Y");
		//user.setCreation_date(new Date().toString());
		user.setTeam_id(dto.getTeamId());
		return userRepository.save(user);

	}

	@Override
	public User find(String id) throws UserNotFoundException {
		return userRepository.getOne(Long.valueOf(id));
	}

	@Override
	public User update(String id, UserDTO dto) throws ModelUpdateFailedException {
		
		User user = findById(Long.valueOf(id));
		
		if(null != dto.getName()) 
			user.setName(dto.getName());
		if(null != dto.getEmail())
			user.setEmail(dto.getEmail());
		if(null != dto.getProfileImgPath())
			user.setProfile_img_Path(dto.getProfileImgPath());
		if(null != dto.getLocation())
			user.setLocation(dto.getLocation());
		if(null != dto.getPlayerRole())
			user.setPlayer_role(dto.getPlayerRole());
		if(null != dto.getBattingStyle())
			user.setBatting_style(dto.getBattingStyle());
		if(null != dto.getBowlingStyle())
			user.setBowling_style(dto.getBowlingStyle());
		if(null != dto.getDob())
			user.setDob(dto.getDob());
		
		return userRepository.save(user);
		
	}

	@Override
	public boolean delete(Long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean forgotPin(String mobileNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String changePin(User user, ChangePinDTO changePinDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User userAuthenticate(LoginDTO loginDto) {
		return userRepository.userAuthenticate(loginDto.getMobileNumber(), loginDto.getPin());
	}

	@Override
	public boolean isUserExist(String mobileNumber) {
		boolean isUsrExists = false;
		if(userRepository.isUsernameExist(mobileNumber) != null)
			isUsrExists = true;
		
		return isUsrExists;
	}

	@Override
	public User findById(long id) {
		User user = null;
		Optional<User> found = userRepository.findById(id);
		if (found.isPresent()) {
			user = found.get();
		}
		return user;
	}

	@Override
	public List<User> findByUserId(String teamId) {
		List<User> playerList = new ArrayList<>();
		playerList = userRepository.findByTeamId(teamId);
		return playerList;
	}

	@Override
	public boolean changePin(ChangePinDTO dto) {
		boolean changePinResult = false;
		try {
			userRepository.changePin(dto.getNewPin(), dto.getMobileNumber());
			changePinResult = true;
		} catch(Exception e) {
			
		}
		
		return changePinResult;
	}

	@Override
	public PlayerProfileDto playerStat(String id) {
		PlayerProfileDto playerProfileDto = new PlayerProfileDto();
		try {
			User user = findById(Long.valueOf(id));
			UserDTO dto = new UserDTO();
			dto.setBattingStyle(user.getBatting_style());
			dto.setBowlingStyle(user.getBowling_style());
			dto.setCountry(user.getCountry());
			dto.setPlayerRole(user.getPlayer_role());
			dto.setDob(user.getDob());
			dto.setName(user.getName());
			dto.setLocation(user.getLocation());
			playerProfileDto.setUserDTO(dto);
			BatmanStatDto bat = batsmanRepository.findBatsmanStat(user.getName());
			BowlStatDto bowl = bowlerRepository.findBowlerStat(user.getName());
			BatmanStatDtoFinal bt = new BatmanStatDtoFinal();					
			if(null != bat) {
				int hs = 0, noc = 0;
				bt.setAvg(bat.getAvg());
				bt.setFours(bat.getFours());
				bt.setMatches(bat.getMatches());
				bt.setRuns(bat.getRuns());
				bt.setSixes(bat.getSixes());
				bt.setStrikerate(bat.getStrikerate());
				try {
					hs = batsmanRepository.getHSIndividual(user.getName());
					bt.setHs(hs);
				} catch(Exception e) {
					
				}
				try {
					noc = batsmanRepository.getNotOutCntIndividual(user.getName());
					bt.setNoc(noc);
				}catch (Exception e) {
					// TODO: handle exception
				}				
				
				
			}
			playerProfileDto.setBattingStat(bt);
			playerProfileDto.setBowlingStat(bowl);
			
			
			List<String> howOutList = batsmanRepository.findBatsmanFieldingDetails();
			List<String> cout = new ArrayList<>();
			List<String> rout = new ArrayList<>();
			List<String> sout = new ArrayList<>();
			if(null != howOutList && !howOutList.isEmpty()) {
				howOutList.forEach(e->{
					if(e.startsWith("(C")) {
						String tempStr = e.substring(4);
						if(tempStr.indexOf(',') != -1) {
							cout.add(tempStr.substring(0,tempStr.indexOf(',')));
						} else {
							if(tempStr.indexOf(' ') != -1) {
								cout.add(tempStr.substring(0,tempStr.indexOf(' ')));
							} else {
								if(tempStr.indexOf('(') != -1) {
									cout.add(tempStr.substring(0,tempStr.indexOf('(')-1));
								}
							}
						}
						
					} else {
						if(e.startsWith("(Run")) {
							rout.add(e.substring(8));
						} else {
							if (e.startsWith("S")) {
								String tempStr = e.substring(3);
								sout.add(tempStr.substring(0, tempStr.indexOf(' ')));
							}
						}
					}
				});
			}
			
						int catches = 0, runouts = 0, stumouts = 0;
						if(null != cout && !cout.isEmpty() && cout.contains(user.getName())) {
							catches = Collections.frequency(cout, user.getName());
						}
						if(null != rout && !rout.isEmpty() && rout.contains(user.getName())) {
							runouts = Collections.frequency(cout, user.getName());
						}
						if(null != sout && !sout.isEmpty() && sout.contains(user.getName())) {
							stumouts = Collections.frequency(cout, user.getName());
						}
						FielderStatDto obj = new FielderStatDto();
						obj.setCatches(catches);
						obj.setRunOuts(runouts);
						obj.setStumping(stumouts);
						obj.setDismissals(catches+runouts+stumouts);
						
			playerProfileDto.setFieldingStat(obj);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return playerProfileDto;
	}

	@Override
	public List<User> findByUserUserIdIn(List<Long> userIdList) {

		return userRepository.findByUserUserIdIn(userIdList);
	}
	@Override
	public User addPlayerToTeam(String mobileNumber, String teamId) {
		User u = userRepository.isUsernameExist(mobileNumber);
		if(u != null) {
			u.setTeam_id(teamId);
		}
		return userRepository.save(u);
	}

	@Override
	public List<User> getListOfAllPLayers(String searchString) {
		
		return userRepository.getListOfAllPLayers(searchString);
	}

	@Override
	public List<User> findByTournamentId(String tournamentId) {
		// TODO Auto-generated method stub
		return userRepository.findByTournamentId(tournamentId);
	}
	
}
