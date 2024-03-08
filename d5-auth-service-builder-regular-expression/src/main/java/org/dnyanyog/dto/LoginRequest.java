package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Component
public class LoginRequest { // DTO => Data Transfer Object
							// View
//	@NotEmpty(message = "Username could not be empty or null.")
//	@Min(value = 8, message = "Username can not be less than 8 char")
//	@Max(value = 15, message = "Username can not be more than 15 char")
	@Pattern(regexp = "[a-zA-Z.-]{8,15}")
	private String username;
	
	@Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[@_-])(?=.{8,15})[a-zA-Z@_-]" )
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
