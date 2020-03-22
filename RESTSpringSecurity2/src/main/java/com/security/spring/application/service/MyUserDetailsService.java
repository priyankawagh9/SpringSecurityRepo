package com.security.spring.application.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.security.spring.application.model.MyUserDetails;
import com.security.spring.application.model.User;

public final class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userService.findUsersByUsername(username);
		user.orElseThrow(()-> new UsernameNotFoundException("User not found:"+ user));
		return user.map(MyUserDetails::new).get();
	}

}
