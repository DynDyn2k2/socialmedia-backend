package com.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.model.Messages;
import com.socialmedia.service.MessageService;

@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {
    @Autowired
    private MessageService service;

    @GetMapping("/getAll")
    public List<Messages> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/conversation_id/{conversation_id}")
    public List<Messages> getMessagesByConversationId(@PathVariable("conversation_id") int id) {
        return service.getAllMessagesByConversationId(id);
    }
}