package com.jczubak.crm.model;

import lombok.Data;

@Data
public class UserEmail {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
