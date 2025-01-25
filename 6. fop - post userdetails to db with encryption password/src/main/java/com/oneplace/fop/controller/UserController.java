package com.oneplace.fop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oneplace.fop.model.UserModel;
import com.oneplace.fop.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody UserModel user) {
		
		UserModel savedUser = service.registerUserService(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}

}
