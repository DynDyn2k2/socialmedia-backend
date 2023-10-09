package com.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.model.Pins;
import com.socialmedia.service.PinService;

@RestController
@RequestMapping("/pins")
@CrossOrigin
public class PinController {
    @Autowired
    private PinService pinService;

    @GetMapping("/getPinByUserId/{param}")
    public List<Pins> getPinsByUserId(@RequestParam int param) {
        return pinService.getPinsByUserId(param);
    }

    @GetMapping("/getAll")
    public List<Pins> getAllPins() {
        return pinService.getAllPins();
    }

}