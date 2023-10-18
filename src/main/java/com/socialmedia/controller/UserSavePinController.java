package com.socialmedia.controller;

import com.socialmedia.model.Boards;
import com.socialmedia.model.Pins;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.model.UserSavePin;
import com.socialmedia.model.Users;
import com.socialmedia.service.BoardService;
import com.socialmedia.service.UserSavePinService;
import com.socialmedia.service.UserService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/userSavePin")
@CrossOrigin
public class UserSavePinController {

    @Autowired
    private UserSavePinService userSavePinservice;
    @Autowired
    private BoardService boardService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAll")
    public List<UserSavePin> getAllUserSavePin() {
        return userSavePinservice.getAllUserSavePin();
    }

    @GetMapping("getPin/{username}/{boardId}")
    public List<Pins> getPinByUserIdAndBoardId(@PathVariable("username") String username, @PathVariable("boardId") int boardId) {
        Optional<Boards> optionalBoard = boardService.findById(boardId);
        Boards board = new Boards();
        if (optionalBoard.isPresent()) {
            board = optionalBoard.get();
        }

        Users user = userService.getUserByUsername(username);


        List<UserSavePin> listUserSavePin = new ArrayList<UserSavePin>();
        List<Pins> listPin = new ArrayList<Pins>();
        
        if (optionalBoard.isPresent() && user!=null) {
            listUserSavePin = userSavePinservice.findAllByUserAndBoard(user, board);
            
            for (UserSavePin item : listUserSavePin) {
                listPin.add(item.getPin());
            }

        }

        return listPin;
    }

}
