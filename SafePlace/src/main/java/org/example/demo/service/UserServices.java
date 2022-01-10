package org.example.demo.service;

import org.example.demo.model.User;
import org.example.demo.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
	
	@Autowired
	UserRepository repo;
	
	public void register(User user) {
		user.setPassword(user.getPassword());
		
		repo.save(user);
	}
	
}
