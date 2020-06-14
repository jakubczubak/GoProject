package com.jczubak.crm.controller;

import com.jczubak.crm.model.Oauth2AuthenticationUrls;
import com.jczubak.crm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/login")
public class LoginController {


    private final LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService=loginService;
    }

    @GetMapping("")
    public String getLoginPage(Model model){

        model.addAttribute("urls", loginService.createOauth2AuthenticationUrlsSet());

        return "login";
    }
}
