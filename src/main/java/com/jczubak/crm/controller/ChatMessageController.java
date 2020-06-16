package com.jczubak.crm.controller;

import com.jczubak.crm.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatMessageController {

    @Value("${webSocketURL}")
    private String webSocketURL;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message getMessage(Message message) {
        return message;
    }


    @GetMapping("/go-pro-chat")
    public String getChatAppPage(){
        return "chat-app";
    }

    @GetMapping("/app/websocket-url")
    @ResponseBody
    public String getWebSocketURL(){
        return webSocketURL;
    }
}
