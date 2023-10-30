package com.socialmedia.controller;

import com.socialmedia.model.Messages;
import com.socialmedia.service.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    
    @GetMapping(value="/conversation_id/{conversation_id}")
    public List<Messages> getMessagesByConversationId(@PathVariable("conversation_id") int id) {
        return service.getAllMessagesByConversationId(id);
    }
}