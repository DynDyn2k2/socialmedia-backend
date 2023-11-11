package com.socialmedia.controller;

import com.socialmedia.model.Users;
import com.socialmedia.service.UserService;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add")
    public ResponseEntity<Users> add(@RequestBody Users user) {
        return new ResponseEntity<>(service.saveUser(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");       
        Users foundUser = service.getUserByUsername(username); 
        if (foundUser != null && foundUser.getPassword().equals(password)) {
            return new ResponseEntity<>(foundUser.getId(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user) {
        // Kiểm tra xem người dùng đã tồn tại chưa
        Users existingUser = service.getUserByUsername(user.getUsername());
        if (existingUser != null) {
            System.out.println(existingUser);
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }
        System.out.println("=========:"+user);
        // Đặt thời gian đăng ký
        user.setCreatedAt(new Date());
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

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }

    @GetMapping("/countAll")
    public long countAll() {
        return service.countAll();
    }

    @GetMapping("/percent7days")
    public double percent7days() {
        Date currentDate = new Date();
        // Tạo một đối tượng Calendar và thiết lập nó với ngày hiện tại
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        // Trừ đi 7 ngày
        calendar.add(Calendar.DAY_OF_MONTH, -7);

        // Lấy ngày mới sau khi đã trừ đi 7 ngày
        Date newDate = calendar.getTime();

        long countAll = service.countAll();
        long count7DayAgo = service.countByCreatedAtBefore(newDate);

        double ratio = (double) count7DayAgo / countAll;
        double percent = Math.round(ratio * 100.0) / 100.0;

        return percent;
    }

    @GetMapping(value = {"/password/{password}"})
    public Users getUserByPassword(@PathVariable("password") String password) {
        return service.getUserByPassword(password);
    }

}

