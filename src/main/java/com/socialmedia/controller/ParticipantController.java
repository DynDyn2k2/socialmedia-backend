package com.socialmedia.controller;

import com.socialmedia.model.Participants;
import com.socialmedia.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participants")
@CrossOrigin
public class ParticipantController {
    @Autowired
    private ParticipantService service;

}