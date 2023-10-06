package com.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.socialmedia.model.Notifications;
import com.socialmedia.service.NotificationService;

@RestController
@RequestMapping("/notifications")
@CrossOrigin
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/import-csv")
    public ResponseEntity<String> importCSV(@RequestParam("file") MultipartFile file) {
        try {
            return null;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    @PostMapping("/add")
    public String add(@RequestBody Notifications not) {
        notificationService.saveNotifications(not);
        return "";
    }

    @GetMapping("/getAll")
    public List<Notifications> list() {
        return notificationService.getAllNotifications();
    }
}
