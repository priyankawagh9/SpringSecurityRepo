package com.security.spring.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.security.spring.application.model.User;

public final class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUsersByUsername(username);
		UserDetails userDetails = getUserDetailsforUser(user);
		return userDetails;
	}

	private UserDetails getUserDetailsforUser(User user) {
		List<GrantedAuthority> listOfAuthorities = getAuthoritiesForUser(user);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, listOfAuthorities);
		
	}

	private List<GrantedAuthority> getAuthoritiesForUser(User user) {
		List<GrantedAuthority> listOfAuthorities = new ArrayList<GrantedAuthority>();
		listOfAuthorities = user.getRoles().stream()
			.map(role->new SimpleGrantedAuthority(role))
			.collect(Collectors.toList());
		return listOfAuthorities;
	}

}
