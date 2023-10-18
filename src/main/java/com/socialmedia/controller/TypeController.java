package com.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.service.TypeService;

@RestController
@RequestMapping("/boards")
@CrossOrigin
public class TypeController {
    @Autowired
    private TypeService service;

}