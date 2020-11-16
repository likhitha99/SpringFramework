package com.sunsoft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sunsoft.model.UserData;

import com.sunsoft.repository.UserRepository;

@Service
public class UserDao {
	@Autowired
	UserRepository userRepository;
	public void insertData(UserData UserObj) {
		userRepository.save(UserObj);
	}
	
	public void deleteRecord(int id) {
		userRepository.deleteById(id);
	}
	
	public boolean SearchRecord(String name, String password) {
		List<UserData> userList = (List<UserData>) userRepository.findAll();
		for(UserData u : userList)
		{
			if(u.getName().contentEquals(name) &&u.getPassword().contentEquals(password))
			{
				return true;
			}
		}
		return false;
			
	}
	
	
	
	public List<UserData> displayAll(){
		List<UserData> userList = (List<UserData>) userRepository.findAll();
		return userList;
	}
}
