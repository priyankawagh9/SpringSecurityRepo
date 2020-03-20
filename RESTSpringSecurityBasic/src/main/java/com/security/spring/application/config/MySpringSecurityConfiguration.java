package com.security.spring.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 * @author TA Important steps for integration of spring security in web
 *         applications are as follows: 1. create simple web application.
 * 
 *         2. add spring-security-starter dependency in the pom.xml : a. it
 *         creates login form in application at the beginning with default
 *         password b. add spring.security.user.name and
 *         spring.security.user.password values in application.properties for
 *         customized basic username and password
 * 
 *         3. Authentication Manager: 
 *         	a. add new configuration class for integrating spring configuration. 
 *         	b. add @EnableWebSecurity annotation at the top of class. 
 *         	c. extend WebSecurityConfigurerAdapter class in this class. 
 *         	d. AuthenticationManager: Override configuration() method which has
 *      		AuthenticationManagerBuilder as argument to customize the
 *         		authenticationManager.
 * 
 *        	 d.1. InMemoryAuthentication: 
 *        			a. user inMemory list of user,passwords and roles; Each user section separated by and() 
 *        			b. Add NoOpPasswordEncoder.
 *         
 *         4. Authorization:
 *         	a. add new configure() method with HttpSecurity as parameter to autherize Requests
 *         		with respect to each antMatcher() uri and hasRole() of users.
 *
 *
 */

@EnableWebSecurity
public class MySpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	/**
	 * AUTHENTICATION:
	 * 
	 * configure() method with AuthenticationManagerBuilder is used 
	 * for Authentication of all users and password using inMemoryAuthentication 
	 */
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

	/**
	 * PasswordEncoder with NoOpPasswordEncoder so that it won't encrypt any password.
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();

	}

	
	/**
	 * AUTHERIZATION:
	 * 
	 * configure() method with HttpSecurity is used 
	 * for Authorization of 
	 * 1. all users to /home api
	 * 2. only user role users can access /user api
	 * 3. only admin role users can access /admin api
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/home").permitAll()
				.antMatchers("/user").hasRole("user")
				.antMatchers("/admin").hasRole("admin")
				.and()
				.formLogin();
	}

}
