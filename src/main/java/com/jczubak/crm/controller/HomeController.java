package com.jczubak.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String getHomePage(){
        return "dashboard";
    }

    @GetMapping("/add")
    public String addPriority(){
        return "newPriority";
    }
}
