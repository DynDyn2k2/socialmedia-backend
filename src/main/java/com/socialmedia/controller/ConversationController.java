package com.socialmedia.controller;

import com.socialmedia.model.Conversations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.service.ConversationService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/conversations")
@CrossOrigin
public class ConversationController {
    @Autowired
    private ConversationService service;

    @GetMapping("/getAll")
    public List<Conversations> list(){
        return service.getAllConversation();
    }
    
    @GetMapping(value={"/id/{id}"})
    public Conversations getConversationById(@PathVariable("id") int id) {
        Optional<Conversations> optional = service.getConversationById(id);
        return optional.get();
    }
}