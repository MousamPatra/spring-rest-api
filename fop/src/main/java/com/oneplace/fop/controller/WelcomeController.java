package com.oneplace.fop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	/*
	 * http://localhost:8080
	 */
	@GetMapping
	public ResponseEntity<Object> sayHello() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello World!");
	}

	/*
	 * http://localhost:8080/hello/Mousam
	 * we are using @RequestParam
	 */
	@GetMapping("hello/{name}")
	public ResponseEntity<Object> sayHello1(@PathVariable String name) {
		return ResponseEntity.status(HttpStatus.OK).body("Hello " + name + "!");
	}

	/*
	 * http://localhost:8080/hello?name=Mousam
	 * we are using @RequestParam
	 */
	@GetMapping("/hello")
	public ResponseEntity<Object> sayHello2(@RequestParam String name) {
		return ResponseEntity.status(HttpStatus.OK).body("Hi " + name + "!!");
	}

	/*
	 * http://localhost:8080/welcome?name=Mousam&greet=Welcome
	 * we are using @RequestParam
	 */
	@GetMapping("/welcome")
	public ResponseEntity<Object> sayHello3(@RequestParam String name, @RequestParam String greet) {
		return ResponseEntity.status(HttpStatus.OK).body(greet + " " + name + "!!!");
	}

}
