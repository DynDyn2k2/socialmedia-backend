package com.socialmedia.controller;

import com.socialmedia.model.Pins;
import com.socialmedia.service.PinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pins")
@CrossOrigin
public class PinController {
    @Autowired
    private PinService service;

}