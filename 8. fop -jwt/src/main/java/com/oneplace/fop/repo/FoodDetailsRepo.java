package com.oneplace.fop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneplace.fop.model.FoodDTO;

@Repository
public interface FoodDetailsRepo extends JpaRepository<FoodDTO, Integer> {

}
