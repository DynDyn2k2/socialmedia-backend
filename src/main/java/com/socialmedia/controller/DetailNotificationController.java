package com.socialmedia.controller;

import com.socialmedia.model.DetailNotification;
import com.socialmedia.service.DetailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detailNotification")
@CrossOrigin
public class DetailNotificationController {
    @Autowired
    private DetailNotificationService service;

}