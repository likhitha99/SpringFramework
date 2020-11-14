package com.sunsoft;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Salary {
	@RequestMapping("/welcome/{id1}")
	public String totalPay(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("basic") int basic,@RequestParam("hra") int hra,@RequestParam("it") int it,@RequestParam("deductions") int deductions,@PathVariable("id1") int id1,Model m) {
		int grossSal=hra+it+basic;
		int netSal=grossSal-deductions;
		
		if(id==115)
		{
			String message="Gross Salary = "+grossSal+" Net Salary = "+netSal;
			m.addAttribute("message",message);
			return "success";
		}
		else {
			String message="Invalid id";
			m.addAttribute("message",message);
			return "invalid";
			
		}
		
	}
	
}
