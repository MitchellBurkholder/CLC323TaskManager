package com.cst323.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController
{
    private final static Logger log = LoggerFactory.getLogger(HomeController.class);
	//maps the home page
    @GetMapping("/")
    public String showHome()
    {
        log.info("entering home controller");
        log.info("home controller executed without issues");
        return "Home";
    }
}
