/**
 * 
 */
package com.aannya.cricplexheros.scorecard.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aannya.cricplexheros.dto.ExtraRunSCDto;
import com.aannya.cricplexheros.scorecard.model.Batsmen;
import com.aannya.cricplexheros.scorecard.model.ExtraRuns;
import com.aannya.cricplexheros.scorecard.model.Inning;

/**
 * @author Babban
 *
 */
@Repository("extraRunRepository")
public interface ExtraRunRepository extends JpaRepository<ExtraRuns, Long>{
	
	@Transactional
	@Modifying
	long deleteByMatchIdAndRandomNumber(String matchId, long randomNumber);
	
	@Query("select e from ExtraRuns e where e.matchId=:matchId and e.inningNumber=:inningNumber")
	ExtraRuns findByMatchId(@Param("matchId") String matchId, @Param("inningNumber") Integer inningNumber);
	
	@Query("select new com.aannya.cricplexheros.dto.ExtraRunSCDto(e.inningNumber,e.teamId,sum(e.byes),sum(e.legbyes),sum(e.wides),sum(e.noballs),\r\n" + 
			"sum(e.total)) from ExtraRuns e where e.matchId=:matchId and e.inningNumber=:inningNumber group by e.inningNumber,e.teamId")
	ExtraRunSCDto extraRunByInning(@Param("matchId") String matchId, @Param("inningNumber") Integer inningNumber);
	
}
