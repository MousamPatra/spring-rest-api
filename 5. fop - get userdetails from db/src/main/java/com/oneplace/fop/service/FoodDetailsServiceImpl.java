package com.oneplace.fop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneplace.fop.model.FoodDTO;
import com.oneplace.fop.repo.FoodDetailsRepo;

@Service
public class FoodDetailsServiceImpl implements FoodDeatilsService {

	@Autowired
	private FoodDetailsRepo foodDetailsRepo;

	@Override
	public List<FoodDTO> getAllFoods() {
		List<FoodDTO> foods = foodDetailsRepo.findAll();
		return foods;
	}

	@Override
	public FoodDTO addFood(FoodDTO food) {
		FoodDTO savedFood = null;
		savedFood = foodDetailsRepo.save(food);
		return savedFood;
	}

}
