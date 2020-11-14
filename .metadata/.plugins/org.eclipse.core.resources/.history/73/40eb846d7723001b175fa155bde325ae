package com.sunsoft;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	@RequestMapping("/login")
	public String helloWorld(HttpServletRequest request,HttpServletResponse res,Model m) {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		if(password.equals("admin") && name.equals("likhitha")) {
			m.addAttribute("id","45");
			m.addAttribute("name",name);
			m.addAttribute("dept","IBGT");
			m.addAttribute("desn","Developer");
			return "hellopage";
		}
		else {
			m.addAttribute("message","Sorry, username or password error");
			return "errorpage";
		}
	}
	

}
