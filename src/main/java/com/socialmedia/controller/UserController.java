package com.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.model.Users;
import com.socialmedia.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/add")
    public String add(@RequestBody Users user) {
        service.saveUser(user);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Users> list() {
        return service.getAllUser();
    }
}