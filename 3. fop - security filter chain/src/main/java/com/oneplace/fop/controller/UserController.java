package com.oneplace.fop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oneplace.fop.model.UserDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {

	List<UserDTO> users = new ArrayList<>(
			List.of(new UserDTO(1, "Mousam", 231.0), new UserDTO(2, "Sid", 123.0), new UserDTO(3, "Akash", 321.0)));

	@GetMapping("/users")
	public ResponseEntity<Object> getUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> addUsers(@RequestBody UserDTO user) {
		users.add(user);
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@GetMapping("/csrf-token")
	public ResponseEntity<Object> getCsrfToken(HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		return ResponseEntity.status(HttpStatus.OK).body(token);
	}
}
