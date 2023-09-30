package com.socialmedia.controller;

import com.socialmedia.model.UserSavePin;
import com.socialmedia.service.UserSavePinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userSavePin")
@CrossOrigin
public class UserSavePinController {
    @Autowired
    private UserSavePinService service;

}