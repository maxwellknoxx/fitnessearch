package com.knoxx.fitnessearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.knoxx.fitnessearch.model.Food;
import com.knoxx.fitnessearch.service.impl.FoodServiceImpl;

@RestController
public class FoodController {

	@Autowired
	private FoodServiceImpl service;

	@GetMapping(path = "/api/v1/foods")
	private ResponseEntity<?> findAll() {
		return new ResponseEntity<List<Food>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/api/v1/foods/{food}")
	private ResponseEntity<?> getByName(@PathVariable String food) {
		return new ResponseEntity<Food>(service.findByName(food), HttpStatus.OK);
	}

}
