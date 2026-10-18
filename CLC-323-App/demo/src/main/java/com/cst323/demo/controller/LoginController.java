package com.cst323.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cst323.demo.model.LoginModel;

@Controller
public class LoginController {

    private final static Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String display(Model model) {
        log.info("entering login controller");
        model.addAttribute("title", "Login Form");
        model.addAttribute("LoginModel", new LoginModel());
        log.info("login controller executed without issues");
        return "Login";
    }
}
