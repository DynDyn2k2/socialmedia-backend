package com.socialmedia.controller;

import com.socialmedia.model.Conversations;
import com.socialmedia.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conversations")
@CrossOrigin
public class ConversationController {
    @Autowired
    private ConversationService service;

}