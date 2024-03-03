package org.dnyanyog.dto;

import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserData {
	
	@NotEmpty(message = "Username could not be empty or null.")
	private String username;
	@NotEmpty(message = "password could not be empty or null.")
	private String password;
	
	@Email
	@NotEmpty(message = "email could not be empty or null.")
	private String email;
	
	@NotEmpty(message = "age could not be empty or null.")
	@NumberFormat
	private String age;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}


}
