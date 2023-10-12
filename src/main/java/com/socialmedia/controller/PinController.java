package com.socialmedia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.model.Pins;
import com.socialmedia.model.Users;
import com.socialmedia.service.PinService;
import com.socialmedia.service.UserService;

@RestController
@RequestMapping("/pins")
@CrossOrigin
public class PinController {

    @Autowired
    private PinService pinService;
    private UserService userService;

    public PinController(PinService pinService, UserService userService) {
        this.pinService = pinService;
        this.userService = userService;
    }

    @GetMapping("/getPinByTypeId/{param}")
    public List<Pins> getPinsByTypeId(@RequestParam Long param) {
        return pinService.getPinsByTypeId(param);
    }

    @GetMapping("/getAll")
    public List<Pins> getAllPins() {
        return pinService.getAllPins();
    }

    @GetMapping("/getPinsByUserCreated")
    public List<Pins> getPinsByUserCreated(@RequestParam(name = "userId") int userId) {
        // TODO: process POST request
        Optional<Users> user = userService.getUserById(userId);
        if (user != null) {
            pinService.getPinsByUserCreated(user);
        } else {
            System.out.println(userId);
            return null;
        }
        return null;
    }

}