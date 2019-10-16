/**
 * 
 */
package com.aannya.cricplexheros.scorecard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aannya.cricplexheros.scorecard.model.PointTable;

/**
 * @author Babban
 *
 */
@Repository("pointsTableRepository")
public interface PointsTableRepository extends JpaRepository<PointTable, Long>{
	
	@Query("select p from PointTable p where p.tournamentId=:tournamentId")
	List<PointTable> getPointTableOfTournament(@Param("tournamentId") String tournamentId);
	
	@Query("select p from PointTable p where p.tournamentId=:tournamentId and p.teamName=:teamName")
	PointTable getPointTableOfTeamByName(@Param("tournamentId") String tournamentId, @Param("teamName") String teamName);

	
}
