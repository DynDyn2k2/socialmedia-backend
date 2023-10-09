package com.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.model.Notifications;
import com.socialmedia.service.NotificationService;

@RestController
@RequestMapping("/notifications")
@CrossOrigin
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/add")
    public String add(@RequestBody Notifications not) {
        notificationService.saveNotifications(not);
        return "";
    }

    @GetMapping("/getAll")
    public List<Notifications> list() {
        return notificationService.getAllNotifications();
    }
}
