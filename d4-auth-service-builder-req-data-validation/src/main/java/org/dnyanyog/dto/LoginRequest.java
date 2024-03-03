package org.dnyanyog.dto;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Component
public class LoginRequest { // DTO => Data Transfer Object
							// View
	@NotEmpty(message = "Username could not be empty or null.")
	@Min(value = 8, message = "Username can not be less than 8 char")
	@Max(value = 15, message = "Username can not be more than 15 char")
	private String username;
	
	@Min(value = 8, message = "Password can not be less than 8 char")
	@Max(value = 15, message = "Password can not be more than 15 char")
	@NotEmpty(message = "Password could not be empty or null.")
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
