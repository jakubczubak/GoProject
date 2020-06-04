package com.jczubak.crm.model;

import lombok.Data;

@Data
public class PasswordDTO {

    private String newPassword;
    

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
