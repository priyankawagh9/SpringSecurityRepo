package com.security.spring.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/home")
	public String homeController()
	{
		return ("<h1>Welcome!</h1>");
	}
	
	@GetMapping("/user")
	public String userController()
	{
		return ("<h1>User Login Successful!</h1>");
	}
	
	@GetMapping("/admin")
	public String adminController()
	{
		return ("<h1>Admin Login Successful!</h1>");
	}
	
}
