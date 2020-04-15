package com.jczubak.crm.controller;

import com.jczubak.crm.entity.Status;
import com.jczubak.crm.entity.User;
import com.jczubak.crm.repository.StatusRepository;
import com.jczubak.crm.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @RequestMapping(value = "/add", produces = "application/json")
    public String addStatus(@RequestBody User user){
       userRepository.save(user);
        return "success";
    }

}
