package com.cst323.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cst323.demo.model.LoginModel;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("LoginModel", new LoginModel());
        return "Login";
    }
}