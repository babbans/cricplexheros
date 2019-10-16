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

import com.aannya.cricplexheros.dto.InningSCDto;
import com.aannya.cricplexheros.scorecard.model.Inning;

/**
 * @author Babban
 *
 */
@Repository("inningRepository")
public interface InningRepository extends JpaRepository<Inning, Long>{
	
	@Modifying
	@Transactional
	@Query("update Inning i set i.status=2 where i.matchId=:matchId and i.number=:inningNumber")
	void updateWhenEnd(@Param("matchId") String matchId, @Param("inningNumber") Integer inningNumber);

	@Transactional
	@Modifying
	long deleteByMatchIdAndRandomNumber(String matchId, long randomNumber);
	
	@Query("select sum(i.inningOver) from Inning i where i.matchId=:matchId and i.number=:inningNumber")
	Integer getbowlscount(@Param("matchId") String matchId, @Param("inningNumber") Integer inningNumber);
		
	@Query("select i from Inning i where i.matchId=:matchId and i.number=:inningNumber")
	Inning findByMatchId(@Param("matchId") String matchId, @Param("inningNumber") Integer inningNumber);
	
	@Query("select sum(i.scores) from Inning i where i.matchId=:matchId and i.number=:inningNumber and i.currentOverNumber=:currentOverNumber")
	Integer sumOfTotalRuns(@Param("matchId") String matchId, @Param("inningNumber") Integer inningNumber, @Param("currentOverNumber") Integer currentOverNumber);
	
	@Query("select new com.aannya.cricplexheros.dto.InningSCDto(i.number,i.name,i.status, i.result, i.battingTeamId,\r\n" + 
			"i.fieldingTeamId,sum(i.scores),sum(i.inningOver)) from Inning i where i.matchId=:matchId and i.number=:inningNumber group by i.number,i.name,i.status, i.result, i.battingTeamId,i.fieldingTeamId")
	InningSCDto inningByInning(@Param("matchId") String matchId, @Param("inningNumber") Integer inningNumber);
}
