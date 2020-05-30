package com.jczubak.crm.service;

import com.jczubak.crm.entity.PasswordResetToken;
import com.jczubak.crm.entity.Token;
import com.jczubak.crm.entity.User;
import com.jczubak.crm.repository.PasswordResetTokenRepository;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.UUID;

@Service
public class PasswordResetTokenService {

    public final PasswordResetTokenRepository passwordResetTokenRepository;
    public final MailService mailService;

    public PasswordResetTokenService(PasswordResetTokenRepository passwordResetTokenRepository, MailService mailService){
        this.passwordResetTokenRepository=passwordResetTokenRepository;
        this.mailService=mailService;
    }


    public void sendToken(User user){
        String tokenValue = UUID.randomUUID().toString();
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setUser(user);
        passwordResetToken.setToken(tokenValue);
        passwordResetTokenRepository.save(passwordResetToken);

        String url = "http://localhost:8080/passwordresettoken?value=" + tokenValue;

        try {
            mailService.sendMail(user.getEmail(),"Reset password", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
