package com.cst323.demo.business;

import com.cst323.demo.data.RegistrationDataServiceInterface;
import com.cst323.demo.model.RegistrationModel;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements RegistrationServiceInterface {

    private final RegistrationDataServiceInterface registrationDataService;

    public RegistrationService(RegistrationDataServiceInterface registrationDataService) {
        this.registrationDataService = registrationDataService;
    }

    @Override
    public void registerUser(RegistrationModel registrationModel) {
        registrationDataService.createUser(registrationModel);
    }
}
