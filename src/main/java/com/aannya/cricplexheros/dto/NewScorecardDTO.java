/**
 * 
 */
package com.aannya.cricplexheros.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Babban
 *
 */
public class NewScorecardDTO {
	
	List<BatsmanSCDto> batsmanList = new ArrayList<>();

	public List<BatsmanSCDto> getBatsmanList() {
		return batsmanList;
	}

	public void setBatsmanList(List<BatsmanSCDto> batsmanList) {
		this.batsmanList = batsmanList;
	}
	
	
}
