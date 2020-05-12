package com.jczubak.crm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/app")
    public String getHomePage(){
        return "dashboard";
    }

    @GetMapping("")
    public String redirectToHomePage(){
        return "redirect:/app";
    }
}
