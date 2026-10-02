package com.cst323.demo.controller;

import com.cst323.demo.model.RegistrationModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cst323.demo.business.RegistrationServiceInterface;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationServiceInterface registrationService;

    // constructor needed for this controller
    public RegistrationController(RegistrationServiceInterface registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/")
    public String displayRegisterForm(Model model) {
        model.addAttribute("title", "Registration Form");
        model.addAttribute("registrationModel", new RegistrationModel());
        return "Registration";
    }

    @PostMapping("/doRegistration")
    public String completeRegistration(
            @Valid @ModelAttribute("registrationModel") RegistrationModel registrationModel,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Registration Form");
            return "Registration";
        }

        registrationService.registerUser(registrationModel);
        return "redirect:/login/";
    }
}
