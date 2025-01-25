package com.oneplace.fop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.oneplace.fop.model.UserModel;
import com.oneplace.fop.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JWTService jwtService;

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);

	public UserModel registerUserService(UserModel user) {
		user.setUserPassword(encoder.encode(user.getUserPassword()));
		UserModel savedUser = repo.save(user);
		return savedUser;
	}

	public String verifyUserLoginService(UserModel user) {

		Authentication authentication = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getUserPassword()));

		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUserName());
		}
		return "Fail";
	}

}
