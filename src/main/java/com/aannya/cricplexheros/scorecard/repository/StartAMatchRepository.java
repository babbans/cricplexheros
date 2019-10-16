/**
 * 
 */
package com.aannya.cricplexheros.scorecard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aannya.cricplexheros.scorecard.model.StartAMatch;

/**
 * @author Babban
 *
 */
@Repository("startAMatchRepository")
public interface StartAMatchRepository extends JpaRepository<StartAMatch, Long>{
	
	@Query("select t from StartAMatch t where t.userId=:userId")
	List<StartAMatch> findByUserId(@Param("userId") String userId);
	
	@Query("select t from StartAMatch t where t.tournamentId=:tournamentId")
	List<StartAMatch> findByTournamentId(@Param("tournamentId") String tournamentId);
	
	Optional<StartAMatch> findById(Long id);
	
	@Query("SELECT M FROM StartAMatch M WHERE LOWER(M.teama_name) LIKE LOWER(concat('%', concat(?1, '%'))) or LOWER(M.teamb_name) LIKE LOWER(concat('%', concat(?1, '%')))")
	List<StartAMatch> getListOfSearchedMatches(String searchString);
}
