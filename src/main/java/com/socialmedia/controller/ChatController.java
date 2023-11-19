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
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent;
/**
 *
 * @author PC
 */
@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {
    
    private Map<String, Integer> roomMap = new HashMap<>();
    
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConversationRepository conversationRepository;
    
    @MessageMapping("/chat/conversation_id/{conversation_id}")
    @SendTo("/room/conversation_id/{conversation_id}")
    public Messages chatting(SimpleMessage sMessage, @DestinationVariable("conversation_id") String conversation_id) throws Exception {
        Thread.sleep(1000); // simulated delay
        Messages message = new Messages();
        message.setContent(sMessage.getContent());
        message.setId(sMessage.getId());
        message.setSend_at(new Date());
        message.setUser(userRepository.findById(sMessage.getUser_id()).get());
        message.setConversation(conversationRepository.findById(sMessage.getConversation_id()).get());
        if(roomMap.get(conversation_id) == 1) {
            message.setSeen(false);
        }
        else {
            message.setSeen(true);
        }
//        return messageRepository.save(message);
        return message;
    }
    
    @SubscribeMapping("/login/{conversation_id}")
    public void initRoom(@DestinationVariable("conversation_id") String conversation_id) {
        int userCount = 1;
        if(roomMap.containsKey(conversation_id)) {
            userCount = 2;
        }
        roomMap.put(conversation_id, userCount);
    }
    
    @MessageMapping("/unsubscribe")
    public void handleUnsubscribe(@Payload String conversation_id) {
        roomMap.put(conversation_id, 1);
//        return "Conversation: " + conversation_id + " === Joined: " + roomMap.get(conversation_id);
    }
}
