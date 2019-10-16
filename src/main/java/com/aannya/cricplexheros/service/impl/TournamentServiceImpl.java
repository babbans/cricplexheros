/**
 * 
 */
package com.aannya.cricplexheros.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aannya.cricplexheros.dto.BatsmanStatDto;
import com.aannya.cricplexheros.dto.BatsmanStats;
import com.aannya.cricplexheros.dto.BowlerStatDto;
import com.aannya.cricplexheros.dto.BowlerStats;
import com.aannya.cricplexheros.dto.FielderStatDto;
import com.aannya.cricplexheros.dto.FileStorageProperties;
import com.aannya.cricplexheros.dto.TournamentDTO;
import com.aannya.cricplexheros.exception.ModelInsertionException;
import com.aannya.cricplexheros.exception.ModelUpdateFailedException;
import com.aannya.cricplexheros.exception.UserNotFoundException;
import com.aannya.cricplexheros.scorecard.model.PointTable;
import com.aannya.cricplexheros.scorecard.model.Tournament;
import com.aannya.cricplexheros.scorecard.repository.BatsmenRepository;
import com.aannya.cricplexheros.scorecard.repository.BowlerRepository;
import com.aannya.cricplexheros.scorecard.repository.PointsTableRepository;
import com.aannya.cricplexheros.scorecard.repository.TournamentRepository;
import com.aannya.cricplexheros.service.TeamService;
import com.aannya.cricplexheros.service.TournamentService;
import com.aannya.cricplexheros.service.UserService;
import com.aannya.cricplexheros.user.model.User;
import com.aannya.cricplexheros.user.repository.UserRepository;

/**
 * @author Babban
 *
 */
@Service
public class TournamentServiceImpl implements TournamentService{
	
	private static final int BatsmanStatDto = 0;

	@Autowired
	TournamentRepository tournamentRepository;
	
	@Autowired
	PointsTableRepository pointsTableRepository;
	
	@Autowired
	FileStorageProperties fileStorageProperties;
	
	@Autowired
	BowlerRepository bowlerRepository;
	
	@Autowired
	BatsmenRepository batsmenRepository;
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	UserService userService;

	@Override
	public Tournament create(TournamentDTO dto) throws ModelInsertionException {
		Tournament tournament = new Tournament();
		
		tournament.setUserId(dto.getUserId());
		if(null != dto.getBannerImgPath())
			tournament.setBannerImgPath(dto.getBannerImgPath());
		else {
			tournament.setBannerImgPath(ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/api/user/downloadFile/")
	                .path("banner_temp08072019.png")
	                .toUriString());
		}
		if(null != dto.getLogoImgPath())
			tournament.setLogoImgPath(dto.getLogoImgPath());
		else {
			tournament.setLogoImgPath(ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/api/user/downloadFile/")
            .path("logo_temp08072019.png")
            .toUriString());
		}
		tournament.setTournamentName(dto.getTournamentName());
		tournament.setCity(dto.getCity());
		tournament.setGround(dto.getGround());
		tournament.setOrganizerName(dto.getOrganizerName());
		tournament.setOrganizerNumber(dto.getOrganizerNumber());
		tournament.setAllowPlayersToConatctForRegistration(dto.getAllowPlayersToConatctForRegistration());
		tournament.setStartDate(dto.getStartDate());
		tournament.setEndDate(dto.getEndDate());
		tournament.setBowlType(dto.getBowlType());
		tournament.setMatchType(dto.getMatchType());
		tournament.setAboutTournament(dto.getAboutTournament());
		
		tournament.setIsActive("Y");
		tournament.setCreatedOn(new Date());
		return tournamentRepository.save(tournament);
	}

	@Override
	public TournamentDTO find(String id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TournamentDTO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tournament update(String id, TournamentDTO object) throws ModelUpdateFailedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTournamentExist(String tournamentName) {
		
		boolean isTournamentExists = false;
		if(tournamentRepository.isTournamentExist(tournamentName) != null)
			isTournamentExists = true;
		
		return isTournamentExists;
		
	}

	@Override
	public List<Tournament> findByUserId(String userId) {
		List<Tournament> tList = new ArrayList<>();
		tList = tournamentRepository.findByUserId(userId);
		return tList;
	}

	@Override
	public List<Tournament> findAll() {		
		return tournamentRepository.findAll();
	}

	@Override
	public List<PointTable> getPointsTable(String tournamentId) {
		List<PointTable> pointsTable = new ArrayList<>();
		pointsTable = pointsTableRepository.getPointTableOfTournament(tournamentId);
		pointsTable.sort((PointTable p1, PointTable p2) -> p2.getPoints() - p1.getPoints());
		return pointsTable;
	}

	@Override
	public Set<String> listFilesUsingJavaIO() {
	    return Stream.of(new File(fileStorageProperties.getUploadDir()+"/flags").listFiles())
	      .filter(file -> !file.isDirectory())
	      .map(File::getName)
	      .collect(Collectors.toSet());
	}

	@Override
	public List<BowlerStatDto> getBowlerStat(String tournamentId) {	
		List<BowlerStatDto> result = new ArrayList<>();
		try {
			List<BowlerStats> list = bowlerRepository.getStat(tournamentId);
			if(!list.isEmpty()) {
				System.out.println("Bowler list count is:" +list.size());
				list.forEach(item->{
					BowlerStatDto obj = new BowlerStatDto();
					obj.setTeamId(item.getTeamId());
					if(null != item.getTeamId()) {
						String teamName = teamService.findById(Long.valueOf(item.getTeamId())).getName();
						if(null != teamName)
							obj.setTeamName(teamName);
					}
					
					obj.setName(item.getName());
					obj.setMatches(item.getMatches());
					obj.setOvers(item.getOvers());
					obj.setRuns(item.getRuns());
					obj.setWickets(item.getWickets());
					if(null != item.getAvg()) {
						obj.setAvg(item.getAvg());
					} else {
						obj.setAvg(0.0);
					}
					if(null != item.getEcon()) {
						obj.setEcon(item.getEcon());
					} else {
						obj.setEcon(0.0);
					}
					if(null != item.getStrikerate()) {
						obj.setSr(item.getStrikerate());
					} else {
						obj.setSr(0.0);
					}
					obj.setMaidens(item.getMaidens());
					
					result.add(obj);
				});
				
			} else {
				System.out.println("List is empty");
			}
			
			return result;
		} catch(Exception e) {
			System.out.println("Exception while getting bowling stats:" +e.getMessage());

			return result;
		}
		
	}

	@Override
	public List<BatsmanStatDto> getBatsmanStat(String tournamentId) {
		List<BatsmanStatDto> result = new ArrayList<>();
		try {
			List<BatsmanStats> list = batsmenRepository.getBatsmanStat(tournamentId);
			if(!list.isEmpty()) {
				System.out.println("Batsman list count is:" +list.size());
				list.forEach(item->{
					if(null != item.getName()) {
						System.out.println(item.getName());
						BatsmanStatDto obj = new BatsmanStatDto();
						obj.setId(item.getId());
						obj.setTeamId(item.getTeamId());
						obj.setTeamName(teamService.findById(Long.valueOf(item.getTeamId())).getName());
						obj.setName(item.getName());
						obj.setMatches(item.getMatches());
						Integer innCnt = batsmenRepository.getInnCnt(item.getId(), tournamentId);
						if(null != innCnt) {
							obj.setInning(innCnt);
						}						
						obj.setRuns(item.getRuns());
						obj.setFours(item.getFours());
						obj.setSixes(item.getSixes());
						if(null != item.getAvg()) {
							obj.setAvg(item.getAvg());
						} else {
							obj.setAvg(0.0);
						}
						if(null != item.getStrikerate()) {
							obj.setSr(item.getStrikerate());
						} else {
							obj.setSr(0.0);
						}
						Integer noc = batsmenRepository.getNotOutCnt(item.getId(), tournamentId);
						if(null != noc) {
							obj.setNoc(noc);
						} else {
							obj.setNoc(0);
						}
						Integer hs = batsmenRepository.getHS(item.getId(), item.getTeamId());
						if(null != hs) {
							obj.setHs(hs);
						} else {
							obj.setHs(0);
						}
						
						result.add(obj);
					}
					
				});
			}
			
			return result;
		} catch(Exception e) {
			System.out.println("Exception while getting batting stats:" +e.getMessage());
			
			return result;
		}
		
		
	}

	@Override
	public List<FielderStatDto> getFielderStat(String tournamentId) {
		List<FielderStatDto> result = new ArrayList<>();
		try {
			List<User> playerList = userService.findByTournamentId(tournamentId);
			List<String> howOutList = batsmenRepository.findBatsmanHowOut(tournamentId);
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
			
			if(null != playerList && !playerList.isEmpty()) {
				playerList.forEach(p->{
					if((null != cout && !cout.isEmpty() && cout.contains(p.getName())) ||
							(null != rout && !rout.isEmpty() && rout.contains(p.getName())) ||
							(null != sout && !sout.isEmpty() && sout.contains(p.getName()))) {
						
						int catches = 0, runouts = 0, stumouts = 0;
						if(null != cout && !cout.isEmpty() && cout.contains(p.getName())) {
							catches = Collections.frequency(cout, p.getName());
						}
						if(null != rout && !rout.isEmpty() && rout.contains(p.getName())) {
							runouts = Collections.frequency(cout, p.getName());
						}
						if(null != sout && !sout.isEmpty() && sout.contains(p.getName())) {
							stumouts = Collections.frequency(cout, p.getName());
						}
						FielderStatDto obj = new FielderStatDto();
						obj.setCatches(catches);
						obj.setRunOuts(runouts);
						obj.setStumping(stumouts);
						obj.setDismissals(catches+runouts+stumouts);
						obj.setName(p.getName());
						obj.setId(p.getUser_id());
						obj.setTeamId(p.getTeam_id());
						result.add(obj);
					}
					
				});
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return result;
	}
	public List<FielderStatDto> getFinalFielderStat(String tournamentId) {
		List<FielderStatDto> result = getFielderStat(tournamentId);
		
		  if(null != result && !result.isEmpty()) {
			  result.stream().filter(e->e.getDismissals() != 0)
			  .sorted(Comparator.comparingInt(FielderStatDto::getDismissals)
					  .reversed())
			  .collect(Collectors.toList())
			  .forEach(e ->{
					if(null != e.getTeamId()) {
						e.setTeamName(teamService.findById(Long.valueOf(e.getTeamId())).getName());
					}
				});
		  }
		 
		 
		return result;
	}
}
