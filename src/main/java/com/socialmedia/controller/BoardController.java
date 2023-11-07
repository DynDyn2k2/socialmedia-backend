package com.socialmedia.controller;

import com.socialmedia.model.Boards;
import com.socialmedia.model.Users;
import com.socialmedia.service.BoardService;
import com.socialmedia.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {
    @Autowired
    private BoardService boardService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/username/{username}")
    public List<Boards> findByUserIdOrderByPinIdAsc(@PathVariable("username") String username) {
        Users user = userService.getUserByUsername(username);
        List<Boards> list = boardService.findByUserOrderByIdAsc(user);
        
        return list;
    }
    
    @GetMapping("/id/{id}")
    public Boards getBoardById(@PathVariable("id") int id) {
        Optional<Boards> optionalBoard = boardService.findById(id);
        Boards board = new Boards();
        if (optionalBoard.isPresent()) {
            board = optionalBoard.get();
        }
        return board;
    }
    
    @PostMapping("/add")
    public boolean saveBoard(@RequestBody Boards board) {
        boardService.saveBoard(board);
        return true;
    }
}
    
