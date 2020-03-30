package com.security.spring.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {
	
	@GetMapping("/worker")
	public String method() {
		return "<h1>Welcome User Worker! </h1>";		
	}
}
