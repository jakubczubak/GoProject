package com.jczubak.crm.controller;

import com.jczubak.crm.service.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserDashboardController {

    @GetMapping("")
    public String getUserPage(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        model.addAttribute("userName", "Hi, " + currentUser.getUser().getName() + "!");
        return "userDashboard";
    }
}
