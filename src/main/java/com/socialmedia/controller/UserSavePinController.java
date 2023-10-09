package com.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.model.UserSavePin;
import com.socialmedia.service.UserSavePinService;

@RestController
@RequestMapping("/userSavePin")
@CrossOrigin
public class UserSavePinController {
    @Autowired
    private UserSavePinService service;

    @GetMapping(value = "/getAll")
    public List<UserSavePin> getAllUserSavePin() {
        return service.getAllUserSavePin();
    }

}