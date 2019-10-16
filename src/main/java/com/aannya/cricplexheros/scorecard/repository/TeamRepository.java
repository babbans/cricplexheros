/**
 * 
 */
package com.aannya.cricplexheros.scorecard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aannya.cricplexheros.scorecard.model.Team;

/**
 * @author Babban
 *
 */
@Repository("teamRepository")
public interface TeamRepository extends JpaRepository<Team, Long>{
	@Query("select t from Team t where t.name=:name and t.isActive='Y'")
	Team isTeamExist(@Param("name") String name);
	
	@Query("select t from Team t where t.tournamentId=:tournamentId and t.isActive='Y'")
	List<Team> findByTournamentId(@Param("tournamentId") String tournamentId);
	
	@Query("select t from Team t where t.userId=:userId and t.isActive='Y'")
	List<Team> findByUserId(@Param("userId") String userId);
	
	@Query("SELECT t FROM Team t WHERE LOWER(t.name) LIKE LOWER(concat('%', concat(?1, '%')))")
	List<Team> getListOfAllTeams(String searchString);
	
}
