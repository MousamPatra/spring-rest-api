package com.oneplace.fop.service;

import java.util.List;

import com.oneplace.fop.model.FoodDTO;

public interface FoodDeatilsService {

	List<FoodDTO> getAllFoods();

	FoodDTO addFood(FoodDTO food);

}
