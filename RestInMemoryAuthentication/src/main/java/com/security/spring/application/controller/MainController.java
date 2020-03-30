package com.security.spring.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("/admin")
public class MainController {
	
	
	@GetMapping("/getUsers")
	public String method() {
		return "<h1>Welcome Admin!</h1>" ;		
	}
	
	@GetMapping("/second")
	public String method2() {
		return "<h1>Welcome second Admin! </h1>" ;		
	}
}
