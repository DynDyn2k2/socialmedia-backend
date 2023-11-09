package com.socialmedia.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmedia.model.Users;
import com.socialmedia.service.UserService;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add")
    public String add(@RequestBody Users user) {
        service.saveUser(user);
        return "New user is added";
    }

    @GetMapping("/getAll")
    public List<Users> list() {
        return service.getAllUsers();
    }

    @GetMapping(value = {"/{username}"})
    public Users getUserByUsername(@PathVariable("username") String username) {
        return service.getUserByUsername(username);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") int id) {
        Optional<Users> optional = service.getUserById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/id/{id}/password")
    public ResponseEntity<String> changeUserPassword(
            @PathVariable("id") int id,
            @RequestBody Map<String, String> request) {
        String currentPassword = request.get("currentPassword");
        String newPassword = request.get("newPassword");

        try {
            service.changeUserPassword(id, currentPassword, newPassword);
            return ResponseEntity.ok("Password changed successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to change password: " + e.getMessage());
        }
    }

    @PutMapping("/id/{id}/privateBool")
    public ResponseEntity<String> changeUserPrivate(
            @PathVariable("id") int id,
            @RequestBody Map<String, Boolean> request) {
        boolean currentState = request.get("currentState");

        try {
            service.changeUserPrivateState(id, currentState);
            return ResponseEntity.ok("Private State changed successfully");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to change private state " + e.getMessage());
        }

    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Users> updateUser(
            @PathVariable("id") int id,
            @RequestBody Users updateUser
    ) {
        Optional<Users> OptionalUser = service.getUserById(id);
        if (OptionalUser.isPresent()) {
            Users user = OptionalUser.get();

            if (!"".equals(updateUser.getFullname()) && updateUser.getFullname() != null) {
                user.setFullname(updateUser.getFullname());
            } else {
                user.setFullname(user.getFullname());
            }
            if (!"".equals(updateUser.getIntroduce()) && updateUser.getIntroduce() != null) {
                user.setIntroduce(updateUser.getIntroduce());
            } else {
                user.setIntroduce(user.getIntroduce());
            }
            if (!"".equals(updateUser.getWebsite()) && updateUser.getWebsite() != null) {
                user.setWebsite(updateUser.getWebsite());

            } else {
                user.setWebsite(user.getWebsite());
            }
            if (!"".equals(updateUser.getUsername()) && updateUser.getUsername() != null) {
                user.setUsername(updateUser.getUsername());
            } else {
                user.setUsername(user.getUsername());
            }

            if (!"".equals(updateUser.getGender()) && updateUser.getGender() != null) {
                user.setGender(updateUser.getGender());
            } else {
                user.setGender(user.getGender());
            }
            if (!"".equals(updateUser.getCountry()) && updateUser.getCountry() != null) {
                user.setCountry(updateUser.getCountry());
            } else {
                user.setCountry(user.getCountry());
            }
            if (!"".equals(updateUser.getLanguage()) && updateUser.getLanguage() != null) {
                user.setLanguage(updateUser.getLanguage());
            } else {
                user.setLanguage(user.getLanguage());
            }

            service.saveUser(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/id/{id}/birthdate")
    public ResponseEntity<Date> updateBirthday(
            @PathVariable("id") int id,
            @RequestBody Map<String, Date> request
    ) {
        Date updateDate = request.get("updateBirthday");
        try {
            service.changeUserbirthday(id, updateDate);
            return ResponseEntity.ok(updateDate);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/id/{id}/avatar")
    public ResponseEntity<String> updateAvatar(
            @PathVariable("id") int id,
            @RequestBody Map<String, String> request
    ) {
        try {
//            Base64.Decoder decoder = Base64.getDecoder();
            String base64String = request.get("base64String");
            System.out.println(base64String);
//            byte[] avatarBytes  = decoder.decode(base64String);
//            byte[] avatarBytes = Base64.getDecoder() .decode(base64String);
            Optional<Users> Optionaluser = service.getUserById(id);
            if (Optionaluser.isPresent()) {
                Users user = Optionaluser.get();
                user.setAvatar(base64String);
                service.saveUser(user);
                return ResponseEntity.ok("Avatar updated successfully");
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update avatar: " + e.getMessage());
        }
    }


}
