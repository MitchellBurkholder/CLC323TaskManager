package com.cst323.demo.business;

import com.cst323.demo.data.entity.UserEntity;
import com.cst323.demo.model.RegistrationModel;

public interface RegistrationServiceInterface {
    public void registerUser(RegistrationModel registrationModel);
    public void deleteUser(UserEntity user);
}
