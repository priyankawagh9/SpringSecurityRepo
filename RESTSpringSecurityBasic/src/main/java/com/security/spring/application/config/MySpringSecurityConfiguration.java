package com.security.spring.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * 
 * @author TA
 * Important steps for integration of spring security in web applications are as follows:
 * 1. create simple web application.
 * 
 * 2. add spring-security-starter dependency in the pom.xml :
 * 			a.  it creates login form in application at the beginning with default password
 * 			b.	add spring.security.user.name and spring.security.user.password values in application.properties for customized basic username and password
 * 
 * 3. Authentication Manager: 
 * 			a.  add new configuration class for integrating spring configuration.
 * 			b.	add @EnableWebSecurity annotation at the top of class.
 * 			c.	extend WebSecurityConfigurerAdapter class in this class.
 * 			d.	AuthenticationManager: 
 * 				Override configuration()method which has AuthenticationManagerBuilder as argument to customize the authenticationManager.
 * 			
 * 			d.1.	InMemoryAuthentication: 
 * 				a.	user inmemory list of user,passwords and roles; Each user section seperated by and()
 * 				b.	Add NoOpPasswordEncoder.			
 *
 *
 */



@EnableWebSecurity
public class MySpringSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
			.withUser("user1")
			.password("user1")
			.roles("user")
			.and()
			.withUser("admin1")
			.password("admin1")
			.roles("admin");
	}
	
	
	@Bean 
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
		
	}

	
}
