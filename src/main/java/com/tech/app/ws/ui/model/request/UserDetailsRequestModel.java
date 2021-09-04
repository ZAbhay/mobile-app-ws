package com.tech.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {

    @NotNull(message = "first name should not be null")
	private String firstName;
	
    @NotNull(message = "last name should not be null")
	private String lastName;
	
	@NotNull(message = "email should not be null")
	@Email
	private String email;
	
	@NotNull
	@Size(min = 4, max = 16, message = "password length should be equal to or greater than 4 characters and less than 16 characters")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
