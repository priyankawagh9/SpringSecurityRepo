package com.security.spring.application.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticationRequest {
	
	@NotBlank(message = "Please enter none empty userName")
	private String userName;
	
	@NotBlank(message = "Please enter none empty password")
	private String password;
}
