package com.security.spring.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/home")
	public String method()
	{
		return "<h1>Welcome!</h1>";
	}
}
