package com.knoxx.fitnessearch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knoxx.fitnessearch.exception.EntityNotFoundException;
import com.knoxx.fitnessearch.model.Food;
import com.knoxx.fitnessearch.repository.FoodRepository;
import com.knoxx.fitnessearch.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository repository;
	
	@Override
	public Food findByName(String name) {
		return repository.findByName(name)
				.orElseThrow(() -> new EntityNotFoundException(Food.class, "Name", name));
	}

	@Override
	public List<Food> findAll() {
		return repository.findAll();
	}

}
