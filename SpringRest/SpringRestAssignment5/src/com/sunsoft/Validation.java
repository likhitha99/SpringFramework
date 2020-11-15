package com.sunsoft;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/details")
public class Validation {
	@RequestMapping(method = RequestMethod.POST)
	public String createEmployee(@RequestParam("name") String name,@RequestParam("password") String password) {
		if(name.contentEquals("likhitha")&& password.contentEquals("123"))
			return "Valid User";
		else if(name.contentEquals("Rohan")&& password.contentEquals("456"))
			return "Valid User";
		else if(name.contentEquals("Lucy")&& password.contentEquals("789"))
			return "Valid User";
		else
			return "Invalid User";
		
	}
	
	
	
}
