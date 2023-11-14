package com.socialmedia.controller;

import com.socialmedia.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.service.CommentService;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/comments")
@CrossOrigin

public class CommentController {
    @Autowired
    private CommentService service;

    @GetMapping("/getAll")
    public List<Comments> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/pin_id/{pin_id}")
    public List<Comments> getByPinId(@PathVariable("pin_id") int pin_id) {
        return service.getByPinId(pin_id);
    }

    @PostMapping("/add")
    public Comments add(@RequestBody Comments comments){
        return service.saveComment(comments);
//        return "New student is added";
    }
    
    @GetMapping("/delete/cmt_id/{cmt_id}")
    public boolean delete(@PathVariable("cmt_id") int cmt_id) {
        return service.delete(cmt_id);
    }
}
