package com.jczubak.crm.controller;

import com.jczubak.crm.entity.User;
import com.jczubak.crm.service.UserService;
import com.jczubak.crm.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserServiceImpl userServiceImpl;

    public RegisterController(UserServiceImpl userServiceImpl){
        this.userServiceImpl=userServiceImpl;
    }

    @GetMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/register")
    public String register(User user){
    userServiceImpl.saveUser(user);
        return "sign-up";
    }
}
