/**
 * 
 */
package com.aannya.cricplexheros.scorecard.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aannya.cricplexheros.dto.LivescoreSCDto;
import com.aannya.cricplexheros.scorecard.model.LiveScore;

/**
 * @author Babban
 *
 */
@Repository("liveRepository")
public interface LiveScoreRepository extends JpaRepository<LiveScore, Long>{
	
	@Transactional
	@Modifying
	long deleteByMatchIdAndRandomNumber(String matchId, long randomNumber);
	
	/*
	 * @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query("update LiveScore l set l.currentPartnershipRuns=0 and l.currentPartnershipBalls=0 where l.matchId=?1"
	 * ) void resetCurrentPartnershipRunsAndBalls(String matchId);
	 */
	List<LiveScore> findByMatchIdAndRandomNumber(String matchId, long randomNumber);
	
	@Query("select new com.aannya.cricplexheros.dto.LivescoreSCDto(sum(l.runs),l.inningNumber,l.overs,sum(l.current_overs),sum(l.wickets)) from LiveScore l where l.matchId=:matchId and l.inningNumber=:inningNumber group by l.inningNumber,l.overs")
	LivescoreSCDto livescoreByInning(@Param("matchId") String matchId, @Param("inningNumber") Integer inningNumber);
	
	@Query("select new com.aannya.cricplexheros.dto.LivescoreSCDto(sum(l.runs),l.inningNumber,l.overs,sum(l.current_overs),sum(l.wickets)) from LiveScore l where l.matchId=:matchId and l.teamId=:teamId group by l.inningNumber,l.overs")
	LivescoreSCDto livescoreByTeamId(@Param("matchId") String matchId, @Param("teamId") String teamId);

	@Query("select l from LiveScore l where l.matchId=:matchId and l.inningNumber=:inningNumber")
	LiveScore findByMatchId(@Param("matchId") String matchId, @Param("inningNumber") Integer inningNumber);
}
