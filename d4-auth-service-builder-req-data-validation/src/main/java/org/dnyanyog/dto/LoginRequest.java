package org.dnyanyog.dto;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;

@Component
public class LoginRequest { // DTO => Data Transfer Object
							// View
	@NotEmpty(message = "Username could not be empty or null.")
	private String username="Admin";
	@NotEmpty(message = "Password could not be empty or null.")
	private String password="Admin123";
	
	
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
