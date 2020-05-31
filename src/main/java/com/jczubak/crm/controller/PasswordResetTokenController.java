package com.jczubak.crm.controller;

import com.jczubak.crm.entity.User;
import com.jczubak.crm.model.GenericResponse;
import com.jczubak.crm.model.PasswordDTO;
import com.jczubak.crm.model.UserEmail;
import com.jczubak.crm.repository.UserRepository;
import com.jczubak.crm.service.PasswordResetTokenService;
import com.jczubak.crm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @ResponseBody
    public GenericResponse processForgetPassword(@RequestBody UserEmail userEmail) {
    Optional<User> user = Optional.ofNullable(userService.findByEmail(userEmail.getEmail()));
    if(user.isPresent()){
        passwordResetTokenService.sendToken(user.get());
        return new GenericResponse("Check your mailbox!");
    }else {
      return new GenericResponse("Email does not exist in the database!");
    }
    }

    @GetMapping("/changePassword")
    public String resetPassword(@RequestParam String tokenValue, Model model){
        boolean result = passwordResetTokenService.validatePasswordResetToken(tokenValue);
        if(result){
            model.addAttribute("token", tokenValue);
            return "updatePassword";
        }else{
            return "redirect:/login?invalidToken";
        }

    }

    @PostMapping("/savePassword")
    public GenericResponse savePassword(PasswordDTO passwordDTO){
    System.out.println(passwordDTO.getToken());
        return new GenericResponse("chuj"); /// sprawdz to!!!!!!!!!
    }

}
