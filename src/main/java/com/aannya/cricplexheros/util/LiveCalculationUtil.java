/**
 * 
 */
package com.aannya.cricplexheros.util;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Component;

import com.aannya.cricplexheros.scorecard.model.StartAMatch;

/**
 * @author Babban
 *
 */
@Component
public class LiveCalculationUtil {
	
	public double getEconomyRate(int runConceded, double overBowled) {
		
		String numberD = String.valueOf(overBowled);
		int intPart = Integer.parseInt(numberD.substring(0, numberD.indexOf(".")));
		double fractionalPart = Double.valueOf(numberD.substring(numberD.indexOf(".")+1));  
		double dividend = intPart + fractionalPart * 0.1667;
		if(dividend != 0.0) {
			return Precision.round(runConceded/dividend, 1);
		} else {
			return Precision.round(runConceded/1.0, 1);
		}
		
		
	}
	public static double calculatePointFirstMatch(StartAMatch match, String wtn, String ltn) {
		double result;
		if(wtn.equalsIgnoreCase(match.getTeama_name())) {
			result = (match.getTeama_score()/match.getTeama_overs()) - (match.getTeamb_score()/match.getTeamb_overs());
		}
		else {
			result = (match.getTeamb_score()/match.getTeamb_overs()) - (match.getTeama_score()/match.getTeama_overs());
		}
		return Precision.round(result, 2);
	}
	public int getOverNumberFromBalls(int balls) {
		int result;
		if (balls %6 == 0) {
			if(balls == 6) {
				result = (balls/6) + 1;
			} else {
				result = balls/6;
			}
			
		} else {
			result = (balls/6) + 1;
		}
		
		return result;
	}
}
