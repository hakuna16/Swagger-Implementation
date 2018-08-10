package com.rituj.swaggerImpl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rituj.swaggerImpl.domain.User;
import com.rituj.swaggerImpl.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public void addNewUser(User user) {
		userRepository.createUser(user);
	}
}
