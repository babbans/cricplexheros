/**
 * 
 */
package com.aannya.cricplexheros.scorecard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aannya.cricplexheros.scorecard.model.InningStatus;

import java.lang.String;
import java.util.List;

/**
 * @author Babban
 *
 */
@Repository
public interface InningStatusRepository extends JpaRepository<InningStatus, Long>{
	
	InningStatus findByMatchIdAndNumber(String matchid, Integer number);
}
