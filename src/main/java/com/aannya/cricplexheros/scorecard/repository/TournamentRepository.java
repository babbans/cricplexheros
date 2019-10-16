/**
 * 
 */
package com.aannya.cricplexheros.scorecard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aannya.cricplexheros.scorecard.model.Tournament;
/**
 * @author Babban
 *
 */
@Repository("tournamentRepository")
public interface TournamentRepository extends JpaRepository<Tournament, Long>{
	 
	@Query("select t from Tournament t where t.tournamentName=:tournamentName and t.isActive='Y'")
	Tournament isTournamentExist(@Param("tournamentName") String tournamentName);
	
	@Query("select t from Tournament t where t.userId=:userId and t.isActive='Y'")
	List<Tournament> findByUserId(@Param("userId") String userId);
}
