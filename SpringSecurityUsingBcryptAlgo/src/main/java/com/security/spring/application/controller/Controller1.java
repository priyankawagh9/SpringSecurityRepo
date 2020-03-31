package com.security.spring.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController("/")
public class Controller1 {

	@GetMapping("/") 
	public ModelAndView redirectMethod(){
		return new ModelAndView("forward:/autherize");
	}
	@GetMapping("/autherize")
	public String autherizeUser() {
		return "Successful Authenticated User using Bcrypt password encoder";
	}
}
