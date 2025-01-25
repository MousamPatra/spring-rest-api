package com.oneplace.fop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class WelcomeController {

	@GetMapping("/")
	public ResponseEntity<Object> sayHello() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello World!");
	}
	
	@GetMapping("/session")
	public ResponseEntity<Object> findSessionId(HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body("Session Id: " + request.getSession().getId());
	}

}
