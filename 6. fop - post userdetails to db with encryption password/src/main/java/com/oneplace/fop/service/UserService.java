package com.oneplace.fop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.oneplace.fop.model.UserModel;
import com.oneplace.fop.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
	
	public UserModel registerUserService(UserModel user) {
		user.setUserPassword(encoder.encode(user.getUserPassword()));
		UserModel savedUser = repo.save(user);
		return savedUser;
	}

}
