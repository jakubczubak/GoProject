package com.jczubak.crm.controller;

import com.jczubak.crm.entity.User;
import com.jczubak.crm.model.UserEmail;
import com.jczubak.crm.repository.UserRepository;
import com.jczubak.crm.service.PasswordResetTokenService;
import com.jczubak.crm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PasswordResetTokenController {

    public final UserService userService;
    public final PasswordResetTokenService passwordResetTokenService;

    public PasswordResetTokenController(UserService userService, PasswordResetTokenService passwordResetTokenService){
        this.userService=userService;
        this.passwordResetTokenService=passwordResetTokenService;
    }

    @GetMapping("/forgetPassword")
    public String getForgetPasswordPage(){
        return "forgetPassword";
    }

  @PostMapping("/forgetPassword")
  public void processForgetPassword(@RequestBody UserEmail userEmail) {

    Optional<User> user = Optional.ofNullable(userService.findByEmail(userEmail.getEmail()));

    if(user.isPresent()){

        passwordResetTokenService.sendToken(user.get());

    }else {
      System.out.println("mail nie istnieje");
    }

    }
}