package com.oneplace.fop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "foods")
public class FoodDTO {

	@Id
	@Column(name = "food_id")
	private int foodId;

	@Column(name = "food_name")
	private String foodName;

	@Column(name = "food_price")
	private double foodPrice;

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	@Override
	public String toString() {
		return "FoodDTO [foodId=" + foodId + ", foodName=" + foodName + ", foodPrice=" + foodPrice + "]";
	}

}
