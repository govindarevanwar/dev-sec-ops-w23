package org.dnyanyog.dto;

import jakarta.validation.constraints.Pattern;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserData {
	
	@Pattern(regexp = "[a-zA-Z.-]{8,15}")
	private String username;
	
	@Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[@_-])(?=.{8,15})[a-zA-Z@_-]" )
	private String password;
	
	@Pattern(regexp = "[a-zA-Z.-]+@[a-zA-Z.-]+\\.[a-zA-Z]{2,}")
	private String email;
	@Pattern(regexp = "[0-9]{1,2}")
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
