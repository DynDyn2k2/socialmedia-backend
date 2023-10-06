package com.socialmedia.controller;

import com.socialmedia.model.Types;
import com.socialmedia.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
@CrossOrigin
public class TypeController {
    @Autowired
    private TypeService service;

}