package com.jczubak.crm.controller;

import com.jczubak.crm.entity.Token;
import com.jczubak.crm.entity.User;
import com.jczubak.crm.service.TokenService;
import com.jczubak.crm.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TokenController {

    private final TokenService tokenService;
    private final UserServiceImpl userServiceImpl;

    public TokenController(TokenService tokenService, UserServiceImpl userServiceImpl){
        this.tokenService=tokenService;
        this.userServiceImpl=userServiceImpl;
    }

    @GetMapping("/token")
    public String confirmAccount(@RequestParam String value){
        Token byValue  = tokenService.findTokenByValue(value);
        User user = byValue.getUser();
        user.setEnabled(true);
        userServiceImpl.updateUser(user);
        return "redirect:/login?active";
    }
}
