package com.jczubak.crm.service;

import com.jczubak.crm.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User findByEmail(String email);

    void saveUser(User user);
}
