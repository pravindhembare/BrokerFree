/*package com.example.BrokerFree.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.BrokerFree.Model.ShortlistedProperty;
import com.example.BrokerFree.Service.ShortlistedPropertyservice;

@RestController
public class ShortlistedPropertyController {
	
	@Autowired
	private ShortlistedPropertyservice spService;
	
	@PostMapping("/addShortlistedProperty")
	public ResponseEntity<?> m2(@RequestBody ShortlistedProperty sp) {
		System.out.println("inside shortlistedProperty property");
		spService.addShortlistedProperty(sp);
	   
	    
		return new ResponseEntity<ShortlistedProperty>(sp, HttpStatus.OK);
	}

}
*/