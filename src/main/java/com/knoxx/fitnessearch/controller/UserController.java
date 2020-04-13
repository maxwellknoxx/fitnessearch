package com.knoxx.fitnessearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.knoxx.fitnessearch.entity.User;
import com.knoxx.fitnessearch.model.UserDTO;
import com.knoxx.fitnessearch.service.impl.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl service;
	
	@GetMapping(path = "/api/v1/users")
	public List<User> findAll(){
		return service.findAll();
	}
	
	
	@PostMapping(path = "/api/v1/users")
	public ResponseEntity<?> create(@RequestBody User entity) {
		UserDTO dto = service.create(entity);
		if(dto == null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}
	
	

}
