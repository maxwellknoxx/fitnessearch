package com.knoxx.fitnessearch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knoxx.fitnessearch.entity.User;
import com.knoxx.fitnessearch.exception.EntityNotFoundException;
import com.knoxx.fitnessearch.model.UserDTO;
import com.knoxx.fitnessearch.repository.UserRepository;
import com.knoxx.fitnessearch.service.UserService;
import com.knoxx.fitnessearch.utils.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	public List<UserDTO> findAll() {
		return UserMapper.entityToDTOList(repository.findAll());
	}

	@Override
	public UserDTO findByEmail(String email) {
		return UserMapper.entityToDTO(repository.findByEmail(email)
				.orElseThrow(() -> new EntityNotFoundException(User.class, "E-mail", email)));
	}

	@Override
	public UserDTO create(User entity) {
		User user = repository.save(entity);
		if (user == null) {
			return null;
		}
		return UserMapper.entityToDTO(user);
	}

	public Boolean update(User entity) {
		try {
			repository.save(entity);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean delete(Long id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public UserDTO login(User entity) {
		User user = repository.findByEmail(entity.getEmail()).orElseThrow();
		if (user.getPassword().equals(entity.getPassword())) {
			return UserMapper.entityToDTO(user);
		}
		return null;
	}

}
