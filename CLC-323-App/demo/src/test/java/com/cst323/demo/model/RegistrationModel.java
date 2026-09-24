package com.cst323.demo.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegistrationModel {
	
	@NotNull(message="first name is required a field")
	@Size(min=1, max=50, message="first name must be between 1 & 32 characters")
	private String firstName;

	@NotNull(message="last name is required a field")
	@Size(min=1, max=50, message="last name must be between 1 & 32 characters")
	private String lastName;

	@NotNull(message="Email is required a field")
	@Size(min=1, max=120, message="Email must be between 1 & 50 characters")
	private String email;

	@NotNull(message="role is required a field")
	@Size(min=1, max=20, message="role must be between 1 & 20 characters")
	private String role;

	@NotNull(message="Password is required a field")
	@Size(min=1, max=32, message="Password must be between 1 & 32 characters")
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
	public void setEmail(String email) {this.email = email;}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
