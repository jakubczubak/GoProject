package com.jczubak.crm.controller;
import com.jczubak.crm.service.CurrentUser;
import com.jczubak.crm.service.UserServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserServiceImpl userServiceImpl;

    public HomeController(UserServiceImpl userService){
        this.userServiceImpl=userService;
    }

    @GetMapping("/app")
    public String getHomePage(@AuthenticationPrincipal OAuth2User principal,@AuthenticationPrincipal CurrentUser currentUser){
        if(currentUser==null){
            String authorizedClientRegistrationId = ((OAuth2AuthenticationToken)((SecurityContextImpl) SecurityContextHolder.getContext()).getAuthentication()).getAuthorizedClientRegistrationId();
            userServiceImpl.save_users_to_DB_who_logged_in_using_oAuth(authorizedClientRegistrationId,principal);
        }
        return "selectionMenu";
    }

    @GetMapping("")
    public String redirectToHomePage(){
        return "redirect:/app";
    }




}
