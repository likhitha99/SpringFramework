package com.sunsoft;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class FullName {
	@RequestMapping(method = RequestMethod.GET)
	public String getMovie(@RequestParam("fname") String fname,@RequestParam("lname") String lname) {
			return(fname+" "+lname);	
	}

}
