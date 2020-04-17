package com.knoxx.fitnessearch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knoxx.fitnessearch.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>  {

	Optional<Food> findByName(String name);
	
}
