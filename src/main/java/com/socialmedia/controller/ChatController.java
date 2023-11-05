/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socialmedia.controller;

import com.socialmedia.model.Messages;
import com.socialmedia.service.MessageService;
import com.socialmedia.webSocketConfig.TempGreeting;
import com.socialmedia.webSocketConfig.TempMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;
/**
 *
 * @author PC
 */
@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {
    @Autowired
    private MessageService service;
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public TempGreeting greeting(TempMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new TempGreeting("Hello" + HtmlUtils.htmlEscape(message.getMessage()));
    } 
}
