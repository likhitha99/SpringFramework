package com.sunsoft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunsoft.model.InsuranceData;
import com.sunsoft.repository.InsuranceRepository;



@Service
public class InsuranceDao {
	@Autowired
	InsuranceRepository insuranceRepository;
	public void insertData(InsuranceData UserObj) {
		insuranceRepository.save(UserObj);
	}
	
	public void deleteRecord(int id) {
		insuranceRepository.deleteById(id);
	}
	
	public boolean SearchRecord(String name, String term) {
		List<InsuranceData> userList = (List<InsuranceData>) insuranceRepository.findAll();
		for(InsuranceData u : userList)
		{
			if(u.getName().contentEquals(name))
			{
				u.setTerm(term);
				return true;
			}
		}
		return false;
			
	}
	
	
	
	public List<InsuranceData> displayAll(){
		List<InsuranceData> userList = (List<InsuranceData>) insuranceRepository.findAll();
		return userList;
	}

}
