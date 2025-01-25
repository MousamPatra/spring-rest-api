package com.oneplace.fop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oneplace.fop.model.UserModel;
import com.oneplace.fop.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userRepo.findByUserName(username);

		if (user == null) {
			System.out.println("User Not Found.");
			throw new UsernameNotFoundException("user not found!");
		}

		return new MyUserDetails(user);
	}

}
