/**
 * 
 */
package com.aannya.cricplexheros.dto;

/**
 * @author Babban
 *
 */
public interface BatsmanStats {
	String getId();
	String getTeamId();
	String getName();
	Integer getMatches();
	Integer getInning();
	Integer getRuns();
	Integer getFours();
	Integer getSixes();
	Double getStrikerate();
	Double getAvg();
	
}
