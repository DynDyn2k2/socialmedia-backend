package com.socialmedia.controller;

import com.socialmedia.model.UserFollowBoard;
import com.socialmedia.service.UserFollowBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userFollowBoard")
@CrossOrigin
public class UserFollowBoardController {
    @Autowired
    private UserFollowBoardService service;

}