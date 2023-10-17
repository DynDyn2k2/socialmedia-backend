package com.socialmedia.controller;

import com.socialmedia.model.Boards;
import com.socialmedia.model.Users;
import com.socialmedia.service.BoardService;
import com.socialmedia.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
@CrossOrigin
public class BoardController {
    @Autowired
    private BoardService boardService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{username}")
    public List<Boards> findByUserIdOrderByPinIdAsc(@PathVariable("username") String username) {
        Users user = userService.getUserByUsername(username);
        List<Boards> list = boardService.findByUserOrderByBoardIdAsc(user);
        
        return list;
    }
}