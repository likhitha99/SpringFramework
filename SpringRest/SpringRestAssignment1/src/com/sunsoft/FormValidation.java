package com.sunsoft;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class FormValidation {
		@RequestMapping(method = RequestMethod.GET)
		public String getMovie(@RequestParam("name") String name,@RequestParam("password") String pwd) {
			
			if(name.contentEquals("Likhitha") && pwd.contentEquals("12345"))
				return "Valid User";
			else
				return "Invalid User";
			
		
}
}
