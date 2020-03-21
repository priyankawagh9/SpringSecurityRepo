package com.security.spring.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.security.spring.application.model.User;
import com.security.spring.application.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User findUsersByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
}
