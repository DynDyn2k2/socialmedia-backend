/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socialmedia.controller;

import com.socialmedia.model.Messages;
import com.socialmedia.repository.ConversationRepository;
import com.socialmedia.repository.MessageRepository;
import com.socialmedia.repository.UserRepository;
import com.socialmedia.webSocketConfig.SimpleMessage;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
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
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConversationRepository conversationRepository;
    
    @MessageMapping("/chat/conversation_id/{conversation_id}")
    @SendTo("/room/conversation_id/{conversation_id}")
    public Messages greeting(SimpleMessage sMessage) throws Exception {
        Thread.sleep(1000); // simulated delay
        Messages message = new Messages();
        message.setContent(sMessage.getContent());
        message.setId(sMessage.getId());
        message.setSend_at(new Date());
        message.setUser(userRepository.findById(sMessage.getUser_id()).get());
        message.setConversation(conversationRepository.findById(sMessage.getConversation_id()).get());
        return messageRepository.save(message);
   }
}
