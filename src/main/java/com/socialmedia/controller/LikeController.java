package com.socialmedia.controller;

import com.socialmedia.model.Likes;
import com.socialmedia.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@CrossOrigin
public class LikeController {
    @Autowired
    private LikeService service;

}