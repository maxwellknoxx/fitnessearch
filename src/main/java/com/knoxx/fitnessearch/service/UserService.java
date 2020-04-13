package com.knoxx.fitnessearch.service;

import com.knoxx.fitnessearch.entity.User;
import com.knoxx.fitnessearch.model.UserDTO;

public interface UserService {
	
	UserDTO findByEmail(String email);
	
	UserDTO create(User entity);
	
	Boolean delete(Long id);
	
}
