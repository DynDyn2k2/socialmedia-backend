package com.socialmedia.controller;

import com.socialmedia.model.Friendships;
import com.socialmedia.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friendships")
@CrossOrigin
public class FriendshipController {
    @Autowired
    private FriendshipService service;

}