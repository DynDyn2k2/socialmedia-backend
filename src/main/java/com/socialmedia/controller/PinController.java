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

    @GetMapping("/username/{username}")
    public List<Pins> findByUserIdOrderByPinIdAsc(@PathVariable("username") String username) {
        Users user = userService.getUserByUsername(username);
        List<Pins> list = pinService.findByUserOrderByIdAsc(user);

        return list;
    }

    @GetMapping("/getPinByTypeId/{param}")
    public List<Pins> getPinsByTypeId(@RequestParam Long param) {
        return pinService.getPinsByTypeId(param);
    }

    @GetMapping("/id/{id}")
    public Pins getPinById(@PathVariable("id") int id) {
        Optional<Pins> optionalPin = pinService.getPinById(id);
        Pins pin = new Pins();
        if (optionalPin.isPresent()) {
            pin = optionalPin.get();
        }
        return pin;
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
            pinService.getPinsByUser(user);
        } else {
            System.out.println(userId);
            return null;
        }
        return null;
    }
    
    @PostMapping("/add")
    public boolean savePin(@RequestBody Pins pin){
        pinService.savePin(pin);
        return true;
    }
}
