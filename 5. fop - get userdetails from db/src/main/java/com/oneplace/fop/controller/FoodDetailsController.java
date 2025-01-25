package com.oneplace.fop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oneplace.fop.model.FoodDTO;
import com.oneplace.fop.service.FoodDeatilsService;

@RestController
public class FoodDetailsController {

	@Autowired
	private FoodDeatilsService foodDetailsService;

	@GetMapping("/foods")
	public ResponseEntity<Object> getUsers() {
		List<FoodDTO> foods = foodDetailsService.getAllFoods();
		return ResponseEntity.status(HttpStatus.OK).body(foods);
	}

	@PostMapping("/foods")
	public ResponseEntity<Object> addUsers(@RequestBody FoodDTO food) {
		FoodDTO savedFood = foodDetailsService.addFood(food);
		return ResponseEntity.status(HttpStatus.OK).body(savedFood);
	}

}
