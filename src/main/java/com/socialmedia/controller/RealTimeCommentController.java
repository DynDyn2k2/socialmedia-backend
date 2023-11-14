/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socialmedia.controller;

import com.socialmedia.webSocketConfig.SimpleComment;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author phmlhuyntrang
 */
@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class RealTimeCommentController {

    @MessageMapping("/addComment")
    @SendTo("/topic/comment")
    public SimpleComment addComment(SimpleComment comment) throws Exception{
        Thread.sleep(1000);
        return comment;
    }
}