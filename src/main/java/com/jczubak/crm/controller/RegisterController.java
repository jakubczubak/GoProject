package com.jczubak.crm.controller;

import com.jczubak.crm.entity.User;
import com.jczubak.crm.service.TokenService;
import com.jczubak.crm.service.UserService;
import com.jczubak.crm.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserServiceImpl userServiceImpl;
    private final TokenService tokenService;

    public RegisterController(UserServiceImpl userServiceImpl, TokenService tokenService){
        this.userServiceImpl=userServiceImpl;
        this.tokenService=tokenService;
    }

    @GetMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/register")
    public String register(User user){
    userServiceImpl.saveUser(user);
    tokenService.sendToken(user);
        return "redirect:/sign-up?status";
    }
}
