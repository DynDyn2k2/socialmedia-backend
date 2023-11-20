package com.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.model.Pins;
import com.socialmedia.service.DetailNotificationService;

@RestController
@RequestMapping("/news_hub")
@CrossOrigin
public class DetailNotificationController {
    @Autowired
    private DetailNotificationService service;

    // Lấy các bài pin trong trang news_hub
    @GetMapping("/{id}")
    public List<Pins> getDetailNotification(@PathVariable("id") int id) {
        return service.getRelatedPins(id);
    }

}