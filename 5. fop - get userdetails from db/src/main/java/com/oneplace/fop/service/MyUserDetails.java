package com.oneplace.fop.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.oneplace.fop.model.UserModel;

public class MyUserDetails implements UserDetails {

	private UserModel user;

	public MyUserDetails(UserModel user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Collections.singleton(new SimpleGrantedAuthority(user.getUserRole()));
	}

	@Override
	public String getPassword() {

		return user.getUserPassword();
	}

	@Override
	public String getUsername() {

		return user.getUserName();
	}

}
