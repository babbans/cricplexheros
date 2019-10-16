/**
 * 
 */
package com.aannya.cricplexheros.service;

import java.util.List;
import java.util.Set;

import com.aannya.cricplexheros.dto.BatsmanStatDto;
import com.aannya.cricplexheros.dto.BowlerStatDto;
import com.aannya.cricplexheros.dto.FielderStatDto;
import com.aannya.cricplexheros.dto.TournamentDTO;
import com.aannya.cricplexheros.exception.ModelInsertionException;
import com.aannya.cricplexheros.exception.ModelUpdateFailedException;
import com.aannya.cricplexheros.exception.UserNotFoundException;
import com.aannya.cricplexheros.scorecard.model.PointTable;
import com.aannya.cricplexheros.scorecard.model.Tournament;

/**
 * @author Babban
 *
 */
public interface TournamentService {
	Tournament create(TournamentDTO object) throws ModelInsertionException;

	TournamentDTO find(String id) throws UserNotFoundException;
	
	TournamentDTO findById(long id);

	Tournament update(String id, TournamentDTO object) throws ModelUpdateFailedException;

	boolean delete(Long userId);

	boolean isTournamentExist(String tournamentName);
	
	List<Tournament> findByUserId(String userId);
	
	List<Tournament> findAll();
	
	List<PointTable> getPointsTable(String tournamentId);
	
	Set<String> listFilesUsingJavaIO();

	List<BowlerStatDto> getBowlerStat(String tournamentId);
	
	List<BatsmanStatDto> getBatsmanStat(String tournamentId);
	
	List<FielderStatDto> getFielderStat(String tournamentId);
	
	List<FielderStatDto> getFinalFielderStat(String tournamentId);
}
