package com.cst323.demo.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("logininfo")
public class LoginInfoEntity {
	
	@Id
	long id;
	
	@Column("USERNAME")
	String username;
	
	@Column("PASSWORD")
	String password;
	
	public LoginInfoEntity(long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
