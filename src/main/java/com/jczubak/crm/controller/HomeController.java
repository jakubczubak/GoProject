package com.jczubak.crm.controller;
import com.jczubak.crm.service.UserService;
import com.jczubak.crm.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private UserServiceImpl userServiceImpl;

    public HomeController(UserServiceImpl userServiceImpl){
        this.userServiceImpl=userServiceImpl;
    }

    @GetMapping("/app")
    public String getHomePage(){
        return "dashboard";
    }

    @GetMapping("")
    public String redirectToHomePage(){
        return "redirect:/app";
    }


}
