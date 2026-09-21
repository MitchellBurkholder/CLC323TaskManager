package com.cst323.demo.data;

import com.cst323.demo.data.entity.LoginInfoEntity;

public interface LoginDataInterface <T> {
	public LoginInfoEntity findByUsername(String username);
	public boolean create(T t);
}
