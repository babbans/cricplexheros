/**
 * 
 */
package com.aannya.cricplexheros.scorecard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aannya.cricplexheros.scorecard.model.MatchResult;

/**
 * @author Aannya
 *
 */
public interface MatchResultRepository extends JpaRepository<MatchResult, Long> {
	
	MatchResult findByMatchId(String matchId);
}
