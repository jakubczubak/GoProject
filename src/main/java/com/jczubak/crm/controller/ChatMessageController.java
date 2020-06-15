package com.jczubak.crm.controller;

import com.jczubak.crm.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatMessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message getMessage(Message message) {
        return message;
    }


    @GetMapping("/go-pro-chat")
    public String getChatAppPage(){
        return "chat-app";
    }
}
