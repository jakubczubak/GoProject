package com.jczubak.crm.service;

import com.jczubak.crm.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private final User user;

    public CurrentUser(String login, String password, Collection<?extends GrantedAuthority> authorities, User user, Boolean isEnabled){
        super(login,password,isEnabled,true,true,true,authorities);
        this.user=user;
    }

    public User getUser(){
        return user;
    }
}
