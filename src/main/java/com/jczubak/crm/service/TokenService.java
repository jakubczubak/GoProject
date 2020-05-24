package com.jczubak.crm.service;

import com.jczubak.crm.entity.Token;
import com.jczubak.crm.entity.User;
import com.jczubak.crm.repository.TokenRepository;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.UUID;

@Service
public class TokenService {

    public final TokenRepository tokenRepository;
    public final MailService mailService;

    public TokenService(TokenRepository tokenRepository, MailService mailService){
        this.tokenRepository=tokenRepository;
        this.mailService=mailService;
    }

    public void sendToken(User user){
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setUser(user);
        token.setValue(tokenValue);
        tokenRepository.save(token);

        String url = "http://localhost:8080/token?value=" + tokenValue;

        try {
            mailService.sendMail(user.getLogin(),"Confirm account", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public Token findTokenByValue(String value){
        return tokenRepository.findByValue(value);
    }
}
