package com.socialmedia.controller;

import com.socialmedia.model.Boards;
import com.socialmedia.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
@CrossOrigin
public class BoardController {
    @Autowired
    private BoardService service;

}