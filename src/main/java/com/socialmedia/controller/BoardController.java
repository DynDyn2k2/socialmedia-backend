package com.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.service.BoardService;

@RestController
@RequestMapping("/boards")
@CrossOrigin
@Qualifier("boardsName")
public class BoardController {
    @Autowired
    private BoardService service;

}