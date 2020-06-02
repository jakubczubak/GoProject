package com.jczubak.crm.service;

import com.jczubak.crm.entity.Token;
import com.jczubak.crm.entity.User;
import com.jczubak.crm.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenService {

    public final TokenRepository tokenRepository;
    public final MailService mailService;
    private final UserServiceImpl userServiceImpl;
    @Value("${hostName}")
    private String hostName;

    public TokenService(TokenRepository tokenRepository, MailService mailService, UserServiceImpl userServiceImpl){
        this.tokenRepository=tokenRepository;
        this.mailService=mailService;
        this.userServiceImpl=userServiceImpl;
    }

    public void sendToken(User user){
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setUser(user);
        token.setValue(tokenValue);
        tokenRepository.save(token);

        String url = hostName + "/token?value=" + tokenValue;

        try {
            mailService.sendMail(user.getEmail(),"Confirm account", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public Optional<Token> findTokenByValue(String value){
        return tokenRepository.findByValue(value);
    }

    public void confirmAccount(String value){
        Optional<Token> byValue  = findTokenByValue(value);
        if(byValue.isPresent()){
            User user = byValue.get().getUser();
            user.setEnabled(true);
            userServiceImpl.updateUser(user);
        }else {
            new RuntimeException("Incorrect token");
        }
    }
}
