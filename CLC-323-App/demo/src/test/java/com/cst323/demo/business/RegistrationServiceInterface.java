package com.cst323.demo.business;

import com.cst323.demo.data.entity.UserEntity;
import com.cst323.demo.model.RegistrationModel;
import org.springframework.security.core.userdetails.UserDetails;

public interface RegistrationServiceInterface {
    public void registerUser(UserEntity user);
    public void deleteUser(UserEntity user);
}
