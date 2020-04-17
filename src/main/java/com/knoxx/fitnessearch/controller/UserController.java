package com.knoxx.fitnessearch.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<UserDTO> findAll() {
		return service.findAll();
	}

	@PostMapping(path = "/api/v1/users")
	public ResponseEntity<?> create(@RequestBody User entity) {
		UserDTO dto = service.create(entity);
		if (dto == null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}

	@PutMapping(path = "api/v1/users")
	public ResponseEntity<?> update(@RequestBody User entity) {
		return new ResponseEntity<Boolean>(service.update(entity), HttpStatus.OK);
	}

	@PostMapping(path = "ap1/v1/users/login")
	private ResponseEntity<?> login(@Valid @RequestBody User entity) {
		UserDTO dto = service.login(entity);
		if (dto == null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		}
		return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
	}

}
