/**
 * 
 */
package com.aannya.cricplexheros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Ugam Sharma
 *
 */
@Controller
/*@RequestMapping("/api/v1")*/
public class TestApi {

	@GetMapping("/test")
	public String test() {
	/*List<Campaign> campaignList = null;
	try {
		campaignList = campaignService.findAll();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
		return "Test successfully done! :)" ;
	}
	
}
