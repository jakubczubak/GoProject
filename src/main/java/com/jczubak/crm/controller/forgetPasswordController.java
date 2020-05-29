package com.jczubak.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class forgetPasswordController {

    @GetMapping("/forgetPassword")
    public String getForgetPasswordPage(){
        return "forgetPassword";
    }
}
