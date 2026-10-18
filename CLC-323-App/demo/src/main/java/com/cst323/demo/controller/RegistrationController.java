package com.cst323.demo.controller;

import com.cst323.demo.model.RegistrationModel;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger log = LoggerFactory.getLogger(RegistrationController.class);

    // constructor needed for this controller
    public RegistrationController(RegistrationServiceInterface registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping({"", "/"})
    public String displayRegisterForm(Model model) {
        log.info("running displayRegisterForm method");
        model.addAttribute("title", "Registration Form");
        model.addAttribute("registrationModel", new RegistrationModel());
        log.info("executed displayRegisterForm method without issue");
        return "Registration";
    }

    @PostMapping("/doRegistration")
    public String completeRegistration(
            @Valid @ModelAttribute("registrationModel") RegistrationModel registrationModel,
            BindingResult bindingResult,
            Model model) {

        log.info("entering completeRegistration method");

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
            model.addAttribute("title", "Registration Form");
            return "Registration";
        }

        registrationService.registerUser(registrationModel);
        log.info("exiting completeRegistration method without issue");
        return "redirect:/login";
    }
}

