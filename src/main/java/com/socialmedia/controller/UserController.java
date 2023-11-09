package com.socialmedia.controller;

import com.socialmedia.model.Users;
import com.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin
// @CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/add")
    public String add(@RequestBody Users user) {
        service.saveUser(user);
        return "New student is added";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        System.out.println(username);
        Users foundUser = service.getUserByUsername(username);
        System.out.println(foundUser);
        if (foundUser != null && foundUser.getPassword().equals(password)) {
            return "Login successful";
        } else {
            return "Login failed";
        }
    }

    // @PostMapping("/register")
    // public Users register(@RequestBody Users user) {
    // return service.saveUser(user);
    // }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user) {
        // Kiểm tra xem người dùng đã tồn tại chưa
        Users existingUser = service.getUserByUsername(user.getUsername());
        if (existingUser != null) {
            System.out.println(existingUser);
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }
        // Đặt thời gian đăng ký
        user.setCreated_at(new Date());
        // Lưu người dùng mới vào cơ sở dữ liệu
        Users registeredUser = service.saveUser(user);

        if (registeredUser != null) {
            System.out.println(registeredUser);
            return new ResponseEntity<>("Registration successful", HttpStatus.OK);
        } else {
            System.out.println(registeredUser);
            return new ResponseEntity<>("Registration failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/getAll")
    public List<Users> list() {
        return service.getAllUsers();
    }

    @GetMapping(value = { "/username/{username}" })
    public Users getUserByUsername(@PathVariable("username") String username) {
        return service.getUserByUsername(username);
    }

    @GetMapping(value = { "/id/{id}" })
    public Users getUserById(@PathVariable("id") int id) {
        Optional<Users> optional = service.getUserById(id);
        return optional.get();
    }

    @GetMapping(value = { "/password/{password}" })
    public Users getUserByPassword(@PathVariable("password") String password) {
        return service.getUserByPassword(password);
    }

}