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

import com.aannya.cricplexheros.dto.BowlStatDto;
import com.aannya.cricplexheros.dto.BowlerSCDto;
import com.aannya.cricplexheros.dto.BowlerStatDto;
import com.aannya.cricplexheros.dto.BowlerStats;
import com.aannya.cricplexheros.scorecard.model.Batsmen;
import com.aannya.cricplexheros.scorecard.model.Bowler;

/**
 * @author Babban
 *
 */
@Repository("bowlerRepository")
public interface BowlerRepository extends JpaRepository<Bowler, Long>{
	
	@Transactional
	@Modifying
	long deleteByMatchIdAndRandomNumber(String matchId, long randomNumber);
	
	@Query("select b from Bowler b where b.bowlerName=:bowlerName")
	Bowler findByName(@Param("bowlerName") String bowlerName);
		
	@Query("select new com.aannya.cricplexheros.dto.BowlerSCDto(b.inningNumber, b.teamId, b.bowlerName, b.bowlerId, sum(b.bowlerOvers),\r\n" + 
			"sum(b.bowlerRunsConceded), sum(b.bowlerWickets),sum(b.bowlerMaidens)) from Bowler b where b.matchId=:matchId and b.inningNumber=:inningNumber group by b.inningNumber, b.teamId, b.bowlerName, b.bowlerId")
	List<BowlerSCDto> bowlersByInning(@Param("matchId") String matchId, @Param("inningNumber") Integer inningNumber);
	
	@Query("select b from Bowler b where b.matchId=:matchId")
	List<Bowler> findByMatchId(@Param("matchId") String matchId);
	
		@Query(nativeQuery = true, value = "select b.team_id as teamId, b.bowler_name as name, sum(b.bowler_runs_conceded) as runs, count(distinct b.match_id) as matches, cast(sum(b.bowler_overs)/6 as unsigned) as overs, sum(b.bowler_wickets) as wickets, sum(b.bowler_maidens) as maidens, ROUND(sum(b.bowler_runs_conceded)/(sum(b.bowler_overs)/6),2) as econ,ROUND(sum(b.bowler_overs)/sum(b.bowler_wickets), 2) as strikerate, ROUND(sum(b.bowler_runs_conceded)/sum(b.bowler_wickets), 2) as avg	FROM cricplex_cricscore.bowler b where b.team_id in (SELECT t.id FROM cricplex_cricscore.team t where t.tournament_id = ?1) and b.match_id in (SELECT m.id FROM cricplex_cricscore.startmatch m where m.tournament_id = ?1) group by b.bowler_name, b.team_id order by wickets desc limit 20;")
	List<BowlerStats> getStat(String tournamentId);
		
	@Query(nativeQuery = true, value = "select sum(b.bowler_runs_conceded) as runs,\r\n" + 
			" count(distinct b.match_id) as matches, cast(sum(b.bowler_overs)/6 as unsigned) as overs,\r\n" + 
			" sum(b.bowler_wickets) as wickets, sum(b.bowler_maidens) as maidens,\r\n" + 
			" ROUND(sum(b.bowler_runs_conceded)/(sum(b.bowler_overs)/6),2) as econ,\r\n" + 
			" ROUND(sum(b.bowler_overs)/sum(b.bowler_wickets), 2) as strikerate,\r\n" + 
			" ROUND(sum(b.bowler_runs_conceded)/sum(b.bowler_wickets), 2) as avg	\r\n" + 
			" FROM cricplex_cricscore.bowler b where b.bowler_name=?1")
	BowlStatDto findBowlerStat(String bowlerName);
	
	@Query("select b from Bowler b where b.bowlerId=:bowlerId and b.matchId=:matchId")
	Bowler findByBowlerId(@Param("bowlerId") String bowlerId, @Param("matchId") String matchId);
	
	@Query("select b from Bowler b where b.matchId=:matchId and b.inningNumber=:inningNumber")
	List<Bowler> findByMatchIdAndInning(@Param("matchId") String matchId, @Param("inningNumber") Integer inningNumber);
}
