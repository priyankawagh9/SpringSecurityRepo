package com.security.spring.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/home")
	public String home() {
		return "<h1>Welcome To Home!!!</h1>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h1>Welcome User!</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Welcome Admin!</h1>";
	}
}
