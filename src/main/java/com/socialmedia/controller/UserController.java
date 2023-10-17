package com.socialmedia.controller;

import com.socialmedia.model.Users;
import com.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/add")
    public String add(@RequestBody Users user){
        service.saveUser(user);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Users> list(){
        return service.getAllUsers();
    }
    
    @GetMapping(value={"/{username}"})
    public Users getUserByUsername(@PathVariable("username") String username){
        return service.getUserByUsername(username);
    }
    
    @GetMapping(value={"/userId{id}"})
    public Users getUserById(@PathVariable("id") int id){
        Optional<Users> optional = service.getUserById(id);
        return optional.get();
    }
    
    
}