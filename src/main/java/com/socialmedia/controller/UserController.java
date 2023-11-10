package com.socialmedia.controller;

import com.socialmedia.model.Users;
import com.socialmedia.service.UserService;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

    @GetMapping("/getAll")
    public List<Users> list() {
        return service.getAllUsers();
    }

    @GetMapping(value = {"/username/{username}"})
    public Users getUserByUsername(@PathVariable("username") String username) {
        return service.getUserByUsername(username);
    }

    @GetMapping(value = {"/id/{id}"})
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
}
