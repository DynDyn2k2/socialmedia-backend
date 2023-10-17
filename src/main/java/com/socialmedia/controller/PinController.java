package com.socialmedia.controller;

import com.socialmedia.model.Boards;
import com.socialmedia.model.Pins;
import com.socialmedia.model.Users;
import com.socialmedia.service.PinService;
import com.socialmedia.service.UserService;
import com.socialmedia.service.BoardService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pins")
@CrossOrigin
public class PinController {

    @Autowired
    private PinService pinService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private BoardService boardService;

    @GetMapping("/{username}")
    public List<Pins> findByUserIdOrderByPinIdAsc(@PathVariable("username") String username) {
        Users user = userService.getUserByUsername(username);
        List<Pins> list = pinService.findByUserOrderByPinIdAsc(user);

        return list;
    }
    
    @GetMapping("/boardId/{id}")
    public List<Pins> getPinByBoardId(@PathVariable("id") int id) {
        Optional<Boards> optional = boardService.findById(id);
        Boards board = optional.get();
        List<Pins> list = pinService.findAllByBoard(board);

        return list;
    }
}
