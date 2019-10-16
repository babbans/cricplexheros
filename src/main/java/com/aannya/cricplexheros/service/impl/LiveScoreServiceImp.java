/**
 * 
 */
package com.aannya.cricplexheros.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aannya.cricplexheros.dto.BatsmanSCDto;
import com.aannya.cricplexheros.dto.BowlerSCDto;
import com.aannya.cricplexheros.dto.ExtraRunSCDto;
import com.aannya.cricplexheros.dto.InningSCDto;
import com.aannya.cricplexheros.dto.LiveScoreDTO;
import com.aannya.cricplexheros.dto.LivescoreSCDto;
import com.aannya.cricplexheros.dto.ScorecardDTO;
import com.aannya.cricplexheros.dto.UndoDTO;
import com.aannya.cricplexheros.scorecard.model.Batsmen;
import com.aannya.cricplexheros.scorecard.model.Bowler;
import com.aannya.cricplexheros.scorecard.model.ExtraRuns;
import com.aannya.cricplexheros.scorecard.model.Inning;
import com.aannya.cricplexheros.scorecard.model.InningStatus;
import com.aannya.cricplexheros.scorecard.model.LiveScore;
import com.aannya.cricplexheros.scorecard.model.StartAMatch;
import com.aannya.cricplexheros.scorecard.model.Team;
import com.aannya.cricplexheros.user.model.User;
import com.aannya.cricplexheros.scorecard.repository.BatsmenRepository;
import com.aannya.cricplexheros.scorecard.repository.BowlerRepository;
import com.aannya.cricplexheros.scorecard.repository.ExtraRunRepository;
import com.aannya.cricplexheros.scorecard.repository.InningRepository;
import com.aannya.cricplexheros.scorecard.repository.InningStatusRepository;
import com.aannya.cricplexheros.scorecard.repository.LiveScoreRepository;
import com.aannya.cricplexheros.scorecard.repository.MatchResultRepository;
import com.aannya.cricplexheros.scorecard.repository.PointsTableRepository;
import com.aannya.cricplexheros.scorecard.repository.StartAMatchRepository;
import com.aannya.cricplexheros.scorecard.repository.TeamRepository;
import com.aannya.cricplexheros.service.LiveScoreService;
import com.aannya.cricplexheros.service.TeamService;
import com.aannya.cricplexheros.service.UserService;
import com.aannya.cricplexheros.util.LiveCalculationUtil;

/**
 * @author Babban
 *
 */
@Service
public class LiveScoreServiceImp implements LiveScoreService{
	@Autowired
	LiveCalculationUtil liveCalculationUtil;
	
	@Autowired
	TeamService teamService;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	StartAMatchRepository startAMatchRepository;
	
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
	InningStatusRepository inningStatusRepository;
	
	@Autowired
	MatchResultRepository matchResultRepository;
	
	@Autowired
	PointsTableRepository ptRepository;
	
	/*@Autowired
	BallByBallRepository ballByBallRepository;
	*/
	@Override
	@Transactional
	public boolean addLiveScore(LiveScoreDTO dto) {
		boolean result = false;
		boolean inningend = false;
		try {
			Optional<StartAMatch> checkStartAMatch = startAMatchRepository.findById(Long.valueOf(dto.getMatchId()));			
			
			if (checkStartAMatch.isPresent() ) {
				StartAMatch match = checkStartAMatch.get();
				if (match.getMatchResult() == null) {
					User striker = userService.findById(Long.valueOf(dto.getStrikerBatsmanId()));
					User nonstriker = userService.findById(Long.valueOf(dto.getNonstrikerBatsmanId()));
					User bowler = userService.findById(Long.valueOf(dto.getBowlerId()));
					
					match.setStrikerBatsman_id(dto.getStrikerBatsmanId());
					match.setNonstrikerBatsman_id(dto.getNonstrikerBatsmanId());
					match.setBowler_id(dto.getBowlerId());
					
						Team batting = teamService.findById(Long.valueOf(dto.getTeamBatting_id()));
						Integer currentInningOver = null;
						try {
							currentInningOver = inningRepository.getbowlscount(dto.getMatchId(), dto.getLiveInningNumber());
						} catch(Exception e) {
							System.out.println("Exception while getting bowls count");
						}
						if(dto.getStrikerBatsmanId() != null && !dto.getStrikerBatsmanId().isEmpty()) {
							List<Batsmen> bl = batsmenRepository.findListByBatsmanId(dto.getStrikerBatsmanId(), dto.getMatchId());
							if(!bl.isEmpty()) {
								Batsmen b = bl.get(0);
								if(b != null && b.getBatsmanHowOut() != null && !b.getBatsmanHowOut().isEmpty() && b.getBatsmanHowOut().equalsIgnoreCase("Retired Hurt")) {
									batsmenRepository.updateBatsmanWhenOut(dto.getStrikerBatsmanId(), dto.getMatchId(), null);
								}
							}
							
						}
						if(dto.getNonstrikerBatsmanId() != null && !dto.getNonstrikerBatsmanId().isEmpty()) {
							List<Batsmen> bl = batsmenRepository.findListByBatsmanId(dto.getNonstrikerBatsmanId(), dto.getMatchId());
							if(!bl.isEmpty()) { 
								Batsmen b = bl.get(0);
								if(b != null && b.getBatsmanHowOut() != null && !b.getBatsmanHowOut().isEmpty() && b.getBatsmanHowOut().equalsIgnoreCase("Retired Hurt")) {
									batsmenRepository.updateBatsmanWhenOut(dto.getNonstrikerBatsmanId(), dto.getMatchId(), null);
								}
							}
							
						}
						if(dto.getStrikerBatsmanId() != null && !dto.getStrikerBatsmanId().isEmpty() && dto.getStriker_how_out().indexOf("Retired Hurt") != -1) { 
							batsmenRepository.updateBatsmanWhenOut(dto.getStrikerBatsmanId(), dto.getMatchId(), "Retired Hurt");
						}
						Inning inning = new Inning();
						Batsmen batsman = new Batsmen();
						LiveScore score = new LiveScore();
						Bowler currentBowler = new Bowler();
						ExtraRuns extraRuns = new ExtraRuns();
						InningSCDto existingInning = inningRepository.inningByInning(String.valueOf(match.getId()), dto.getLiveInningNumber());
						
						//insert/update bowler
						currentBowler.setRandomNumber(dto.getRandomNumber());
						currentBowler.setTeamId(dto.getTeamBowling_id());
						currentBowler.setBowlerMaidens(dto.getMaidanOvers());
						currentBowler.setBowlerId(dto.getBowlerId());
						currentBowler.setBowlerName(bowler.getName());
						currentBowler.setInningNumber(dto.getLiveInningNumber());
						currentBowler.setMatchId(dto.getMatchId());
						//insert/update batsmen 
						batsman.setRandomNumber(dto.getRandomNumber());
						batsman.setTeamId(dto.getTeamBatting_id());
						batsman.setBatsmanName(striker.getName());
						batsman.setMatchId(dto.getMatchId());
						batsman.setInningNumber(dto.getLiveInningNumber());
						batsman.setBatsmanId(dto.getStrikerBatsmanId());
						batsman.setBatsman4Runs(dto.getStrikerBatsman4s());
						batsman.setBatsman6Runs(dto.getStrikerBatsman6s());
						
						//insert/update live score
						score.setRandomNumber(dto.getRandomNumber());
						score.setMatchId(dto.getMatchId());
						score.setOvers(Integer.valueOf(match.getNoOfOver()));
						score.setRuns(dto.getCurrentBallRun());
						score.setTeamId(dto.getTeamBatting_id());
						score.setInningNumber(dto.getLiveInningNumber());
						score.setCurrentPartnershipBalls(dto.getCurrentPartnershipBalls());
						score.setCurrentPartnershipRuns(dto.getCurrentPartnershipRuns());
						
						//insert/update inning
						inning.setRandomNumber(dto.getRandomNumber());
						inning.setName(batting.getName());
						inning.setBattingTeamId(dto.getTeamBatting_id());
						inning.setFieldingTeamId(dto.getTeamBowling_id());
						inning.setMatchId(dto.getMatchId());
						inning.setNumber(dto.getLiveInningNumber());
						inning.setTournamentId(dto.getTournamentId());
						inning.setScores(dto.getCurrentBallRun());
						inning.setStatus(1);
						if(currentInningOver == null ) {
							inning.setCurrentOverNumber(liveCalculationUtil.getOverNumberFromBalls(1));
						} else if(currentInningOver == 1) {
							inning.setCurrentOverNumber(liveCalculationUtil.getOverNumberFromBalls(2));
						} else {
							inning.setCurrentOverNumber(liveCalculationUtil.getOverNumberFromBalls(currentInningOver));
						}					
						
						//insert/update extra runs
						if(dto.getIsExtraRun().equalsIgnoreCase("yes")) {
							int totalExtra = dto.getByes() + dto.getLegbyes() + dto.getNoballs() + dto.getWides();
							extraRuns.setRandomNumber(dto.getRandomNumber());
							extraRuns.setMatchId(dto.getMatchId());
							extraRuns.setTournamentId(dto.getTournamentId());
							extraRuns.setInningNumber(dto.getLiveInningNumber());
							extraRuns.setTotal(totalExtra);
							batsman.setBatsmanRuns(dto.getCurrentBallRun() - totalExtra);
							extraRuns.setTeamId(dto.getTeamBatting_id());
							if(dto.getNoballs() != 0 || dto.getWides() != 0) {
								currentBowler.setBowlerOvers(0);
								currentBowler.setBowlerRunsConceded(dto.getCurrentBallRun());
								extraRuns.setWides(dto.getWides());
								extraRuns.setNoballs(dto.getNoballs());
								extraRuns.setByes(dto.getByes());
								batsman.setBatsmanBallsFaced(0);
								//score.setCurrentPartnershipBalls(0);
								if(dto.getNoballs() != 0) {
									currentBowler.setBowlerRunsConceded(dto.getCurrentBallRun() - dto.getByes() - dto.getLegbyes());
									extraRuns.setLegbyes(dto.getLegbyes());
								}
							
							} else {
								if(existingInning != null && (Integer.parseInt(match.getNoOfOver()) == (existingInning.getInningOver()+1)/6)) {
									inningend = true;
								}
								extraRuns.setLegbyes(dto.getLegbyes());
								extraRuns.setByes(dto.getByes());
								currentBowler.setBowlerOvers(1);
								score.setCurrent_overs(1.0);
								inning.setInningOver(1);
								batsman.setBatsmanBallsFaced(1);
								//score.setCurrentPartnershipBalls(1);
								//currentBowler.setBowlerRunsConceded(dto.getCurrentBallRun());
							}
							extraRunRepository.save(extraRuns);
						} else {
							if(existingInning != null && (Integer.parseInt(match.getNoOfOver()) == (existingInning.getInningOver()+1)/6)) {
								inningend = true;
							}
							batsman.setBatsmanRuns(dto.getCurrentBallRun());
							batsman.setBatsmanBallsFaced(1);
							//score.setCurrentPartnershipBalls(1);
							currentBowler.setBowlerOvers(1);
							score.setCurrent_overs(1.0);
							inning.setInningOver(1);
							currentBowler.setBowlerRunsConceded(dto.getCurrentBallRun());
						}
						if(!dto.getStriker_how_out().isEmpty()) {
							batsman.setBatsmanHowOut(dto.getStriker_how_out());
							if(dto.getStriker_how_out().indexOf("Retired Hurt") != -1) {
								score.setWickets(0);
								batting.setWicket(0);
								
								batsman.setBatsmanBallsFaced(0);
								score.setCurrentPartnershipBalls(0);
								currentBowler.setBowlerOvers(0);
								score.setCurrent_overs(0.0);
								inning.setInningOver(0);
							} else {
								score.setWickets(1);
								batting.setWicket(1);
							}
							if(dto.getStriker_how_out().indexOf("Retired_Out") != -1) {
								batsman.setBatsmanBallsFaced(0);
								//score.setCurrentPartnershipBalls(0);
								currentBowler.setBowlerOvers(0);
								score.setCurrent_overs(0.0);
								inning.setInningOver(0);
							}
							if(dto.getStriker_how_out().indexOf("RunOut") == -1 && dto.getStriker_how_out().indexOf("Retired_Out") == -1 && 
									dto.getStriker_how_out().indexOf("Retired Hurt") == -1) {
								currentBowler.setBowlerWickets(1);
							}
							batsmenRepository.updateBatsmanWhenOut(dto.getStrikerBatsmanId(), dto.getMatchId(), dto.getStriker_how_out());
						}
						if(!dto.getNonstriker_how_out().isEmpty()) {
							batsman.setBatsmanHowOut(dto.getNonstriker_how_out());
							batsman.setBatsmanName(nonstriker.getName());
							batsman.setBatsmanId(dto.getNonstrikerBatsmanId());	
							if(dto.getNonstriker_how_out().indexOf("Retired Hurt") != -1) {
								score.setWickets(0);
								batting.setWicket(0);
								
								batsman.setBatsmanBallsFaced(0);
								//score.setCurrentPartnershipBalls(0);
								currentBowler.setBowlerOvers(0);
								score.setCurrent_overs(0.0);
								inning.setInningOver(0);
							} else {
								score.setWickets(1);
								batting.setWicket(1);
							}
							if(dto.getNonstriker_how_out().indexOf("Retired_Out") != -1) {
								batsman.setBatsmanBallsFaced(0);
								//score.setCurrentPartnershipBalls(0);
								currentBowler.setBowlerOvers(0);
								score.setCurrent_overs(0.0);
								inning.setInningOver(0);
							}
							if(dto.getNonstriker_how_out().indexOf("RunOut") == -1 && dto.getNonstriker_how_out().indexOf("Retired_Out") == -1 && 
									dto.getNonstriker_how_out().indexOf("Retired Hurt") == -1) {
								currentBowler.setBowlerWickets(1);
							}
							batsmenRepository.updateBatsmanWhenOut(dto.getNonstrikerBatsmanId(), dto.getMatchId(), dto.getNonstriker_how_out());
						}
						liveScoreRepository.save(score);
						
							
						batsmenRepository.save(batsman);
							
						if(match.getTeama_id().equalsIgnoreCase(dto.getTeamBatting_id())) {
							LivescoreSCDto livescoreSCDto = liveScoreRepository.livescoreByTeamId(String.valueOf(match.getId()), match.getTeama_id());
							match.setTeama_score(livescoreSCDto.getRuns().intValue());
							match.setTeama_wicket(livescoreSCDto.getWickets().intValue());
							match.setTeama_overs(livescoreSCDto.getCurrent_overs().doubleValue());
							int getCurrentOver = (int) (livescoreSCDto.getCurrent_overs()/6);
							long actualPlayingElevenCnt = match.getPlayingElevenTeamaCount() > 11 ? 11 : match.getPlayingElevenTeamaCount();
							if(String.valueOf(getCurrentOver).equalsIgnoreCase(match.getNoOfOver()) || (livescoreSCDto != null && (livescoreSCDto.getWickets() == (actualPlayingElevenCnt - 1)))) {
								inningend = true;
							}
						} else {
							LivescoreSCDto livescoreSCDto = liveScoreRepository.livescoreByTeamId(String.valueOf(match.getId()), match.getTeamb_id());
							match.setTeamb_score(livescoreSCDto.getRuns().intValue());
							match.setTeamb_wicket(livescoreSCDto.getWickets().intValue());
							match.setTeamb_overs(livescoreSCDto.getCurrent_overs().doubleValue());
							int getCurrentOver = (int) (livescoreSCDto.getCurrent_overs()/6);
							long actualPlayingElevenCnt = match.getPlayingElevenTeambCount() > 11 ? 11 : match.getPlayingElevenTeambCount();
							if(String.valueOf(getCurrentOver).equalsIgnoreCase(match.getNoOfOver()) || (livescoreSCDto != null && (livescoreSCDto.getWickets() == (actualPlayingElevenCnt - 1)))) {
								inningend = true;
							}
						}
						if(existingInning != null && existingInning.getNumber() == 2) {
							InningSCDto inningOne = inningRepository.inningByInning(String.valueOf(match.getId()), 1);
							if(inningOne != null && inningOne.getScores() < (existingInning.getScores() + dto.getCurrentBallRun()))
								inningend = true;
							
						}
						if(inningend) {
							inning.setStatus(2);
							inningRepository.updateWhenEnd(dto.getMatchId(), dto.getLiveInningNumber());
							if(existingInning != null && existingInning.getNumber() == 2) {
								InningStatus inningStatus = new InningStatus();
								inningStatus.setMatchId(dto.getMatchId());
								inningStatus.setNumber(dto.getLiveInningNumber());
								inningStatus.setStatus(2);
								inningStatus.setTournamentId(dto.getTournamentId());
								
								inningStatusRepository.save(inningStatus);
							} else {
								inning.setStatus(2);
							}						
						} 
						
						inningRepository.save(inning);
						
						startAMatchRepository.save(match);
						try {
							Integer updatedCurrentInningOver = inningRepository.getbowlscount(dto.getMatchId(), dto.getLiveInningNumber());
							if(null != updatedCurrentInningOver && updatedCurrentInningOver%6 == 0) {
								int curover = liveCalculationUtil.getOverNumberFromBalls(updatedCurrentInningOver);
								int bowlerScore = inningRepository.sumOfTotalRuns(dto.getMatchId(), dto.getLiveInningNumber(), curover);
								if(bowlerScore == 0) 
									currentBowler.setBowlerMaidens(1);
							}
						} catch (Exception e) {
							System.out.println("Exception while updating maiden over");
						}
						
						
						bowlerRepository.save(currentBowler);
					
						
					
					result = true;
				
				} 
				
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
				
		return result;
	}

	@Override
	public ScorecardDTO scorecard(String matchId) {
		ScorecardDTO scorecardDTO = new ScorecardDTO();

		Optional<StartAMatch> checkStartAMatch = startAMatchRepository.findById(Long.valueOf(matchId));
		StartAMatch match = null;
		if (checkStartAMatch.isPresent()) {
			match = checkStartAMatch.get();
			LivescoreSCDto firstInningScore = null;
			LivescoreSCDto secondInningScore = null;
			List<BatsmanSCDto> firstInningBatsmen = null;
			List<BatsmanSCDto> secondInningBatsmen = null;
			List<BowlerSCDto> firstInningBowler = null;
			List<BowlerSCDto> secondInningBowler = null;
			InningSCDto inningOne = null;
			InningSCDto inningTwo = null;
			ExtraRunSCDto extraRunsInningOne = null;
			ExtraRunSCDto extraRunsInningTwo = null;
			InningStatus inningStatus = null;
			try {
				firstInningScore = liveScoreRepository.livescoreByInning(matchId, 1);
			} catch (Exception e) {
				System.out.println("Exception while getting live score of inning 1 and matchid is ->"+matchId);
			}
			try {
				secondInningScore = liveScoreRepository.livescoreByInning(matchId, 2);
			} catch (Exception e) {
				System.out.println("Exception while getting live score of inning 2 and matchid is ->"+matchId);
			}
			try {
				firstInningBatsmen = batsmenRepository.batsmenByInning(matchId,1);
			} catch (Exception e) {
				System.out.println("Exception while getting batsman list of inning 1 and  matchid ->"+matchId);
			}
			try {
				secondInningBatsmen = batsmenRepository.batsmenByInning(matchId,2);
			} catch (Exception e) {
				System.out.println("Exception while getting batsman list of inning 2 and  matchid ->"+matchId);
			}
			try {
				firstInningBowler = bowlerRepository.bowlersByInning(matchId, 1);
			} catch (Exception e) {
				System.out.println("Exception while getting bowler list of inning 1 and  matchid ->"+matchId);
			}
			try {
				secondInningBowler = bowlerRepository.bowlersByInning(matchId, 2);
			} catch (Exception e) {
				System.out.println("Exception while getting bowler list of inning 2 and  matchid ->"+matchId);
			}
			
			try {
				inningOne = inningRepository.inningByInning(matchId, 1);
			} catch (Exception e) {
				System.out.println("Exception while getting inning of inning 1 and  matchid ->"+matchId);
			}
			try {
				inningTwo = inningRepository.inningByInning(matchId, 2);
			} catch (Exception e) {
				System.out.println("Exception while getting inning of inning 2 and  matchid ->"+matchId);
			}
			try {
				extraRunsInningOne = extraRunRepository.extraRunByInning(matchId, 1);
			} catch (Exception e) {
				System.out.println("Exception while getting extraRunsInningOne of  matchid ->"+matchId);
			}
			try {
				extraRunsInningTwo = extraRunRepository.extraRunByInning(matchId, 2);
			} catch (Exception e) {
				System.out.println("Exception while getting extraRunsInningTwo of  matchid ->"+matchId);
			}
			try {
				inningStatus = inningStatusRepository.findByMatchIdAndNumber(matchId, 2);
			} catch (Exception e) {
				System.out.println("Exception while getting inningStatus of matchid ->"+matchId);
			}
			
		long team1TotalScore;
		long team2TotalScore;
		long runDiff;
		long wicketDiff;
		String winTeamName = null;
		String lossedTeamName = null;
		
		if(inningStatus != null && inningStatus.getStatus() == 2) {
			scorecardDTO.setStatus("Completed");
			match.setStatus("Completed");
			team1TotalScore = inningOne.getScores();
			team2TotalScore = inningTwo.getScores();
			runDiff = team1TotalScore - team2TotalScore;
			String mr = null;
			long actualWicketCountTeamb = match.getPlayingElevenTeambCount() > 11 ? 11 : match.getPlayingElevenTeambCount();
			long actualWicketCountTeama = match.getPlayingElevenTeamaCount() > 11 ? 11 : match.getPlayingElevenTeamaCount();
		
			if(runDiff > 0) {
				winTeamName = inningOne.getName();
				lossedTeamName = inningTwo.getName();
				mr = winTeamName+" won by " + runDiff + " runs";
				scorecardDTO.setMatchResult(mr);
				match.setMatchResult(mr);
				
			} else {
				if(match.getTeamb_id().equalsIgnoreCase(inningTwo.getBattingTeamId())) {
					wicketDiff = actualWicketCountTeamb-1 - secondInningScore.getWickets();
				} else {
					wicketDiff = actualWicketCountTeama-1 - secondInningScore.getWickets();
				}	
				winTeamName = inningTwo.getName();
				lossedTeamName = inningOne.getName();
				mr = inningTwo.getName()+" won by " + wicketDiff+" wickets";
				scorecardDTO.setMatchResult(mr);
				match.setMatchResult(mr);
			}
				if (matchResultRepository.findByMatchId(matchId) == null) {
					/*
					 * 
					 * MatchResult res = new MatchResult(); res.setMatchId(matchId);
					 * res.setMatchResult(mr); res.setCompleted(true);
					 * 
					 * matchResultRepository.save(res);
					 * 
					 * PointTable winner =
					 * ptRepository.getPointTableOfTeamByName(match.getTournamentId(), winTeamName);
					 * PointTable loser =
					 * ptRepository.getPointTableOfTeamByName(match.getTournamentId(),
					 * lossedTeamName);
					 * 
					 * PointTable updatedWinner = new PointTable(); if(winner != null) {
					 * updatedWinner.setId(winner.getId());
					 * updatedWinner.setMatchLost(winner.getMatchLost());
					 * updatedWinner.setMatchNoResult(winner.getMatchNoResult());
					 * updatedWinner.setMatchPlayed(winner.getMatchPlayed()+1);
					 * updatedWinner.setMatchWon(winner.getMatchWon()+1);
					 * updatedWinner.setMatchTied(winner.getMatchTied());
					 * updatedWinner.setPoints(winner.getPoints()+2);
					 * updatedWinner.setNetRunRate(0.0);
					 * updatedWinner.setTeamName(winner.getTeamName());
					 * updatedWinner.setTournamentId(winner.getTournamentId()); } else {
					 * updatedWinner.setMatchLost(1); updatedWinner.setMatchPlayed(1);
					 * updatedWinner.setMatchWon(1); updatedWinner.setPoints(2);
					 * updatedWinner.setNetRunRate(LiveCalculationUtil.calculatePointFirstMatch(
					 * match, winTeamName, lossedTeamName)); updatedWinner.setTeamName(winTeamName);
					 * updatedWinner.setTournamentId(match.getTournamentId());
					 * 
					 * } PointTable updatedLoser = new PointTable(); if(loser != null) {
					 * updatedLoser.setId(loser.getId());
					 * updatedLoser.setMatchLost(loser.getMatchLost()+1);
					 * updatedLoser.setMatchNoResult(loser.getMatchNoResult());
					 * updatedLoser.setMatchPlayed(loser.getMatchPlayed()+1);
					 * updatedLoser.setMatchWon(loser.getMatchWon());
					 * updatedLoser.setMatchTied(loser.getMatchTied());
					 * updatedLoser.setPoints(loser.getPoints()); updatedLoser.setNetRunRate(0.0);
					 * updatedLoser.setTeamName(loser.getTeamName());
					 * updatedLoser.setTournamentId(loser.getTournamentId());
					 * 
					 * } else { updatedLoser.setMatchLost(1); updatedLoser.setMatchPlayed(1);
					 * updatedLoser.setNetRunRate(-LiveCalculationUtil.calculatePointFirstMatch(
					 * match, winTeamName, lossedTeamName));
					 * updatedLoser.setTeamName(lossedTeamName);
					 * updatedLoser.setTournamentId(match.getTournamentId());
					 * 
					 * }
					 * 
					 * ptRepository.save(updatedWinner); ptRepository.save(updatedLoser);
					 */}				
				
		} else {
			scorecardDTO.setStatus("Live");
			match.setStatus("Live");
		}
		startAMatchRepository.save(match);
		scorecardDTO.setExtraRunsInningOne(extraRunsInningOne);
		scorecardDTO.setExtraRunsInningTwo(extraRunsInningTwo);
		scorecardDTO.setFirstInningBatsmen(firstInningBatsmen);
		scorecardDTO.setFirstInningBowler(firstInningBowler);
		scorecardDTO.setSecondInningBatsmen(secondInningBatsmen);
		scorecardDTO.setSecondInningBowler(secondInningBowler);
		scorecardDTO.setInningOne(inningOne);
		scorecardDTO.setInningTwo(inningTwo);
		scorecardDTO.setFirstInningScore(firstInningScore);
		scorecardDTO.setSecondInningScore(secondInningScore);
		
		}
		return scorecardDTO;
	}

	@Override
	public List<Batsmen> batsmenList(String matchId, int inningNumber) {
		return null;
	}

	@Override
	public List<Bowler> bowlerList(String matchId, int inningNumber) {
		return null;
	}
	
	@Transactional
	@Override
	public boolean undo(UndoDTO undoDTO) {
		boolean result = false;
		try {
			long inningDelResult = inningRepository.deleteByMatchIdAndRandomNumber(undoDTO.getMatchId(), undoDTO.getRandomNumber());
			Batsmen batsman = batsmenRepository.findByMatchIdAndRandomNumber(undoDTO.getMatchId(),undoDTO.getRandomNumber());
			if(batsman != null && batsman.getBatsmanHowOut() != null) {
				batsmenRepository.updateBatsmanWhenOut(batsman.getBatsmanId(), undoDTO.getMatchId(), null);
			}
			long batsmanDelResult = batsmenRepository.deleteByMatchIdAndRandomNumber(undoDTO.getMatchId(), undoDTO.getRandomNumber());
			long bowlerDelResult = bowlerRepository.deleteByMatchIdAndRandomNumber(undoDTO.getMatchId(), undoDTO.getRandomNumber());
			long liveScoreDelResult = liveScoreRepository.deleteByMatchIdAndRandomNumber(undoDTO.getMatchId(), undoDTO.getRandomNumber());
			long extraRunDelResult = extraRunRepository.deleteByMatchIdAndRandomNumber(undoDTO.getMatchId(), undoDTO.getRandomNumber());
			
			if(inningDelResult != 0 && batsmanDelResult != 0 && bowlerDelResult != 0 && liveScoreDelResult != 0)
				result = true;
			
		} catch(Exception e) {
			
		}		
		return result;
	}

	@Override
	public boolean checkRandomNum(String matchId, long randomNumber) {
		boolean result = false;
		List<LiveScore> list = liveScoreRepository.findByMatchIdAndRandomNumber(matchId, randomNumber);
		if(list != null && !list.isEmpty()) {
			result = true;
		} 
		return result;
	}


}
