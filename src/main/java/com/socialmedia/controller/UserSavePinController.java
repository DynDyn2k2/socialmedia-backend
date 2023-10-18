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

    @PostMapping("/add")
    public String savePin(@RequestBody UserSavePin userSavePin) {
        service.saveUserSavePin(userSavePin);
        return "Lưu thành công";
    }

}