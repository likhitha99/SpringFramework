package com.sunsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunsoft.dao.InsuranceDao;

import com.sunsoft.model.InsuranceData;


@RestController
public class InsuranceController {
	@Autowired
	InsuranceDao insuranceDao;
	@RequestMapping("/insert")
	public String insertData()
	{
		InsuranceData u1=new InsuranceData();
		u1.setId(14);
		u1.setName("Likhitha");
		u1.setType("Birla Sunlife");
		u1.setTerm("Annual");
		
		InsuranceData u2=new InsuranceData();
		u2.setId(12);
		u2.setName("Linda");
		u2.setType("HDFC Life");
		u1.setTerm("Annual");
		
		
		insuranceDao.insertData(u1);
		insuranceDao.insertData(u2);
		return "Data inserted succesfully";
				
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable("id") int id)
	{
		insuranceDao.deleteRecord(id);
		return "Record deleted successfully";
	}
	
	
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateData(@RequestBody String body)
	{
		String name = body.split("&")[0].split("=")[1]; 
		name=name.replace('+', ' '); 
		String term = body.split("&")[1].split("=")[1];
		term=term.replace('+', ' ');
		if(insuranceDao.SearchRecord(name, term)==true)
		{
		return "Updated the Value";
		}
		else
		{
			return "Enter correct user details";
		}
	}
	
	
	@RequestMapping("/displayAll")
	public List<InsuranceData> displayData()
	{
		List<InsuranceData> userList=insuranceDao.displayAll();
		return userList;
	}

}
