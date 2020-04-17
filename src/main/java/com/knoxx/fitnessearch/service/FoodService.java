package com.knoxx.fitnessearch.service;

import java.util.List;

import com.knoxx.fitnessearch.model.Food;

public interface FoodService {
	
	Food findByName(String name);
	
	List<Food> findAll();
	
}
