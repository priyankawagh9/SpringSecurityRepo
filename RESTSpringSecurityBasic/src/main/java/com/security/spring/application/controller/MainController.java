package com.security.spring.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/firstController")
	public String firstController()
	{
		return ("<h1>Login Successful!</h1>");
	}
	
}
