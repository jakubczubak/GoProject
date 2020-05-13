package com.jczubak.crm;

import com.jczubak.crm.service.UserServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class OnStartUp {

    private UserServiceImpl userServiceImpl;

    public OnStartUp(UserServiceImpl userServiceImpl){
        this.userServiceImpl=userServiceImpl;
        userServiceImpl.createDefaultUserAccount();
    }
}
