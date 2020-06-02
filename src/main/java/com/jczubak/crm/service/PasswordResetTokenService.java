package com.jczubak.crm.service;

import com.jczubak.crm.entity.PasswordResetToken;
import com.jczubak.crm.entity.User;
import com.jczubak.crm.repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Optional;
import java.util.UUID;

@Service
public class PasswordResetTokenService {

    public final PasswordResetTokenRepository passwordResetTokenRepository;
    public final MailService mailService;
    @Value("${hostName")
    private String hostName;

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

        String url = hostName + "/changePassword?tokenValue=" + tokenValue;

        try {
            mailService.sendMail(user.getEmail(),"Reset password", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public boolean validatePasswordResetToken(String tokenValue){
        Optional<PasswordResetToken> passwordResetToken = passwordResetTokenRepository.findByToken(tokenValue);
        if(passwordResetToken.isPresent()){
            return true;
        }else{
            return false;
        }
    }
}
