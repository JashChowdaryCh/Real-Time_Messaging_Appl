package com.Real_Time.Messaging.App.ChattingApp.controller;


import com.Real_Time.Messaging.App.ChattingApp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")

    public ChatMessage sendMessage(ChatMessage message){
        return message;

    }

    @GetMapping("chat")
    public String Chat(){
        return "chat";

    }
}
