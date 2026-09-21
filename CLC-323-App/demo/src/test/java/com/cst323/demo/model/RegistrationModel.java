package com.cst323.demo.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegistrationModel {
	
	@NotNull(message="first name is required field")
	@Size(min=1, max=32, message="first name must be bewteen 1 & 32 characters")
	private String firstName;
	
	@NotNull(message="last name is required field")
	@Size(min=1, max=32, message="last name must be bewteen 1 & 32 characters")
	private String lastName;
	
	@NotNull(message="Email is required field")
	@Size(min=1, max=50, message="Email must be bewteen 1 & 50 characters")
	private String email;
	
	@NotNull(message="Phone number is required field")
	@Size(min=1, max=20, message="Phone number must be bewteen 1 & 20 characters")
	private String phoneNumber;
	
	@NotNull(message="User name is required field")
	@Size(min=1, max=32, message="User name must be bewteen 1 & 32 characters")
	private String username;
	
	@NotNull(message="Password is required field")
	@Size(min=1, max=32, message="Password must be bewteen 1 & 32 characters")
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
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
