package com.jczubak.crm.controller;
import com.jczubak.crm.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/app")
    public String getHomePage(){
        return "selectionMenu";
    }

    @GetMapping("")
    public String redirectToHomePage(){
        return "redirect:/app";
    }




}
