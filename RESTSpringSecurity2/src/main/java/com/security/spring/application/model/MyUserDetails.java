package com.security.spring.application.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	String username;
	String password;
	boolean active;
	private List<GrantedAuthority> authorities;
	
	public MyUserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public MyUserDetails(User user) {
		username = user.getUsername();
		password = user.getPassword();
		active = true;
//		authorities = user.getRoles().stream()
//						.map(SimpleGrantedAuthority::new)
//						.collect(Collectors.toList());
		authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRoles()));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

}
