package com.jczubak.crm.controller;

import com.jczubak.crm.entity.User;
import com.jczubak.crm.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/app/users")
public class UserController {

    private UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpls){
        this.userServiceImpl=userServiceImpls;
    }

    @PostMapping(value = "/add", produces = "application/json")
    public String addStatus(@RequestBody User user){
       userServiceImpl.saveUser(user);
        return "success";
    }

    @GetMapping("/list")
    public List<User> getUserList(){
        return userServiceImpl.getUserList();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUsersByID(@PathVariable Long id){
        userServiceImpl.deleteUserByID(id);
        return "success";
    }

}
