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

import com.aannya.cricplexheros.dto.BatmanStatDto;
import com.aannya.cricplexheros.dto.BatsmanSCDto;
import com.aannya.cricplexheros.dto.BatsmanStatDto;
import com.aannya.cricplexheros.dto.BatsmanStats;
import com.aannya.cricplexheros.scorecard.model.Batsmen;

/**
 * @author Babban
 *
 */
@Repository("batsmenRepository")
public interface BatsmenRepository extends JpaRepository<Batsmen, Long>{
	
	@Transactional
	@Modifying
	long deleteByMatchIdAndRandomNumber(String matchId, long randomNumber);
	
	Batsmen findByMatchIdAndRandomNumber(String matchId, long randomNumber);
	
	@Query("select new com.aannya.cricplexheros.dto.BatsmanSCDto(b.teamId,b.inningNumber,b.batsmanName,b.batsmanId, sum(b.batsmanRuns),\r\n" + 
			"sum(b.batsman4Runs),sum(b.batsman6Runs),sum(b.batsmanBallsFaced),b.batsmanHowOut) from Batsmen b where b.matchId=:matchId and b.inningNumber=:inningNumber group by b.batsmanName, b.teamId,b.inningNumber,b.batsmanName,b.batsmanId,b.batsmanHowOut")
	List<BatsmanSCDto> batsmenByInning(@Param("matchId") String matchId, @Param("inningNumber") Integer inningNumber);

	@Query("select b from Batsmen b where b.batsmanName=:batsmanName")
	Batsmen findByName(@Param("batsmanName") String batsmanName);
	
	@Query(nativeQuery = true, value = "SELECT b.batsman_id as id, b.team_id as teamId, b.batsman_name as name, count(distinct b.match_id) as matches, count(distinct b.inning_number) as inning,\r\n" + 
			"sum(b.batsman_runs) as runs, sum(b.batsman_4_runs) as fours, sum(b.batsman_6_runs) as sixes,\r\n" + 
			"Round((sum(b.batsman_runs)/sum(b.batsman_balls_faced))*100, 2) as strikerate, Round(sum(b.batsman_runs)/count(distinct b.batsman_how_out), 2) as avg\r\n" + 
			"FROM cricplex_cricscore.batsmen b where b.team_id in (SELECT t.id FROM cricplex_cricscore.team t where t.tournament_id = ?1) and  b.match_id in (SELECT m.id FROM cricplex_cricscore.startmatch m where m.tournament_id = ?1) \r\n" + 
			"group by b.team_id, b.batsman_name, b.batsman_id;\r\n" + 
			"")
	List<BatsmanStats> getBatsmanStat(String tournamentId);
	
	
	@Query(nativeQuery = true, value = "SELECT count(distinct b.match_id) as matches, sum(b.batsman_runs) as runs, sum(b.batsman_4_runs) as fours, sum(b.batsman_6_runs) as sixes,\r\n" + 
			"			Round((sum(b.batsman_runs)/sum(b.batsman_balls_faced))*100, 2) as strikerate, Round(sum(b.batsman_runs)/count(distinct b.batsman_how_out), 2) as avg \r\n" + 
			"			FROM cricplex_cricscore.batsmen b where b.batsman_name=?1")
	BatmanStatDto findBatsmanStat(String batsmanName);
	
	@Query(nativeQuery = true, value = "select count(distinct b.batsman_name) from cricplex_cricscore.batsmen b\r\n" + 
			"where b.batsman_how_out is null and b.batsman_id = ?1 and b.match_id in (select m.id from cricplex_cricscore.startmatch m where m.tournament_id=?2);")
	Integer getNotOutCnt(String batsmanId, String tournamentId);
	
	@Query(nativeQuery = true, value = "select count(*) from (select  b.match_id as matches , b.inning_number as inning from cricplex_cricscore.batsmen b where batsman_id=?1 and b.match_id in (select m.id from cricplex_cricscore.startmatch m where m.tournament_id=?2) group by b.match_id, b.inning_number) ci;")
	Integer getInnCnt(String batsmanId, String tournamentId);
	
	//Integer getMatchCnt(String batsmanId, String tournamentId);
	
	@Query(nativeQuery = true, value = "select max(tt.runs) as hs from (select b.match_id as mid, sum(b.batsman_runs) as runs \r\n" + 
			"from cricplex_cricscore.batsmen b where b.batsman_id = ?1 and b.team_id = ?2  group by b.match_id) tt;")
	Integer getHS(String batsmanId, String teamId);
	
	@Query(nativeQuery = true, value = "select max(tt.runs) as hs from (select b.match_id as mid, sum(b.batsman_runs) as runs \r\n" + 
			"			from cricplex_cricscore.batsmen b where b.batsman_name = ?1 group by b.match_id) tt;")
	Integer getHSIndividual(String batsmanName);
	
	@Query(nativeQuery = true, value = "select count(distinct b.batsman_name) from cricplex_cricscore.batsmen b\r\n" + 
			"where b.batsman_how_out is null and b.batsman_name = ?1;")
	Integer getNotOutCntIndividual(String batsmanName);
	
	@Query("select b from Batsmen b where b.matchId=:matchId")
	List<Batsmen> findByMatchId(@Param("matchId") String matchId);
	
	@Query("select b from Batsmen b where b.batsmanId=:batsmanId and b.matchId=:matchId")
	Batsmen findByBatsmanId(@Param("batsmanId") String batsmanId, @Param("matchId") String matchId);
	
	@Query("select b from Batsmen b where b.batsmanId=:batsmanId and b.matchId=:matchId")
	List<Batsmen> findListByBatsmanId(@Param("batsmanId") String batsmanId, @Param("matchId") String matchId);
	
	
	@Query("select b from Batsmen b where b.matchId=:matchId and b.inningNumber=:inningNumber")
	List<Batsmen> findByMatchIdAndInning(@Param("matchId") String matchId, @Param("inningNumber") Integer inningNumber);
	
	@Modifying
	@Transactional
	@Query("update Batsmen b set b.batsmanHowOut=:batsmanHowOut where b.batsmanId=:batsmanId and b.matchId=:matchId")
	void updateBatsmanWhenOut(@Param("batsmanId") String batsmanId, @Param("matchId") String matchId, @Param("batsmanHowOut") String batsmanHowOut);

	@Query(nativeQuery = true, value = "SELECT distinct b.batsman_how_out FROM cricplex_cricscore.batsmen b where b.match_id in (select m.id from cricplex_cricscore.startmatch m where m.tournament_id=?1) and b.batsman_how_out is not null and b.batsman_how_out not like 'b%' and b.batsman_how_out not like '(b%' and b.batsman_how_out not like 'LB%' and b.batsman_how_out not like '(LB%';\r\n" + 
			"")
	List<String> findBatsmanHowOut(String tournamentId);
	
	@Query(nativeQuery = true, value = "SELECT distinct b.batsman_how_out FROM cricplex_cricscore.batsmen b where b.batsman_how_out is not null and b.batsman_how_out not like 'b%' and b.batsman_how_out not like '(b%' and b.batsman_how_out not like 'LB%' and b.batsman_how_out not like '(LB%';\r\n" + 
			"")
	List<String> findBatsmanFieldingDetails();
}
