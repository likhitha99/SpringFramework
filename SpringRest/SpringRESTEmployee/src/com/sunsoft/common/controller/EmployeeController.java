package com.sunsoft.common.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunsoft.common.model.Employee;
@RestController
@RequestMapping("/hello")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	public String getMovie(@RequestParam("name") String name,@RequestParam("password") String pwd) {
		
		if(name.contentEquals("Likhitha") && pwd.contentEquals("12345"))
			return "Valid User";
		else
			return "Invalid User";
		
	}
	
	