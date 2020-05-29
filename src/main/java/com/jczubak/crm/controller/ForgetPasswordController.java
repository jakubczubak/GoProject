package com.jczubak.crm.controller;

import com.jczubak.crm.model.UserEmail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ForgetPasswordController {

    @GetMapping("/forgetPassword")
    public String getForgetPasswordPage(){
        return "forgetPassword";
    }

  @PostMapping("/forgetPassword")
  public void processForgetPassword(@RequestBody UserEmail userEmail) {

    System.out.println(userEmail.getEmail());
    }
}
