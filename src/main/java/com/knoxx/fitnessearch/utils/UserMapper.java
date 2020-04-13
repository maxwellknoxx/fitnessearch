package com.knoxx.fitnessearch.utils;

import org.springframework.stereotype.Component;

import com.knoxx.fitnessearch.entity.User;
import com.knoxx.fitnessearch.model.UserDTO;

@Component
public class UserMapper {
	
	public static UserDTO entityToDTO(User entity) {
		return UserDTO.builder().name(entity.getName())
				.password(entity.getPassword())
				.email(entity.getEmail())
				.height(entity.getHeight())
				.weight(entity.getWeight())
				.proteinPerDay(entity.getProteinPerDay())
				.carboPerDay(entity.getCarboPerDay())
				.fatPerDay(entity.getFatPerDay()).build();
	}
	
	public static User DTOtoEntity(UserDTO dto) {
		return User.builder().name(dto.getName())
				.password(dto.getPassword())
				.email(dto.getEmail())
				.height(dto.getHeight())
				.weight(dto.getWeight())
				.proteinPerDay(dto.getProteinPerDay())
				.carboPerDay(dto.getCarboPerDay())
				.fatPerDay(dto.getFatPerDay()).build();
	}

}
