package com.knoxx.fitnessearch.utils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.knoxx.fitnessearch.entity.User;
import com.knoxx.fitnessearch.model.UserDTO;

@Component
public class UserMapper {
	
	public static UserDTO entityToDTO(User entity) {
		return UserDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.email(entity.getEmail())
				.height(entity.getHeight())
				.weight(entity.getWeight())
				.proteinPerDay(entity.getProteinPerDay())
				.carboPerDay(entity.getCarboPerDay())
				.fatPerDay(entity.getFatPerDay()).build();
	}
	
	public static List<UserDTO> entityToDTOList(List<User> list) {
		return list.stream().filter(Objects::nonNull).map(entity -> UserDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.email(entity.getEmail())
				.height(entity.getHeight())
				.weight(entity.getWeight())
				.proteinPerDay(entity.getProteinPerDay())
				.carboPerDay(entity.getCarboPerDay())
				.fatPerDay(entity.getFatPerDay()).build())
				.collect(Collectors.toList());
	}

}
