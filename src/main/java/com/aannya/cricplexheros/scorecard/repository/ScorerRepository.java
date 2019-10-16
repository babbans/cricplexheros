package com.aannya.cricplexheros.scorecard.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.aannya.cricplexheros.scorecard.model.Scorer;

public interface ScorerRepository extends JpaRepository<Scorer, Long>{
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = "update scorer s set s.is_active=false where s.match_id=?1")
	void updateScorer(String matchId);
	
	@Query(nativeQuery = true, value = "select * from scorer s where s.match_id=?1 and s.is_active=true")
	Scorer findScorer(String matchId);
}
