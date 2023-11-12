/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socialmedia.controller;

import com.socialmedia.model.Messages;
import com.socialmedia.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
/**
 *
 * @author PC
 */
@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {
    @Autowired
    private MessageRepository repository;
    
    @MessageMapping("/chat/conversation/{conversation_id}")
    @SendTo("/room/conversation_id/{conversation_id}")
    public Messages greeting(Messages message) throws Exception {
        Thread.sleep(1000); // simulated delay 
        return repository.save(message);
   }
}
