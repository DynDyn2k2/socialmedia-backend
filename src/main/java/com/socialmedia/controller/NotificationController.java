package com.socialmedia.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.model.Notifications;
import com.socialmedia.model.Pins;
import com.socialmedia.model.Users;
import com.socialmedia.repository.NotificationRepository;
import com.socialmedia.service.DetailNotificationService;
import com.socialmedia.service.NotificationService;
import com.socialmedia.service.UserSavePinService;
import com.socialmedia.service.UserService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/notifications")
@CrossOrigin
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private NotificationService service;

    private NotificationRepository repository;

    private UserService userService;

    private SimpMessagingTemplate mess;

    private UserSavePinService userSavePinService;

    private DetailNotificationService detailService;

    public NotificationController(NotificationService service, NotificationRepository repository,
            UserService userService, SimpMessagingTemplate mess, UserSavePinService userSavePinService,
            DetailNotificationService detailService) {
        this.service = service;
        this.repository = repository;
        this.userService = userService;
        this.mess = mess;
        this.userSavePinService = userSavePinService;
        this.detailService = detailService;
    }

    @GetMapping("/user/{userId}")
    public List<Notifications> getNotifications(@PathVariable("userId") int userId) {
        return service.getNotificationsByUser(userId);
    }

    @Transactional
    public void sendNotifications(@Payload List<Notifications> nots, @DestinationVariable int userId) {
        messagingTemplate.convertAndSend("/room/update-nots/" + userId, nots);
    }

    @PostMapping("/init/{userId}")
    public void initNotifications(@RequestBody Notifications not, @PathVariable("userId") int userId) {
        Users user = userService.getUserById(userId).get();
        not.setUser(user);
        Notifications notifications = service.initNotifications(not.getNotificationType(), userId);
        repository.saveAndFlush(notifications);
        switch (not.getNotificationType()) {
            case Pin:
                List<Pins> pins = new ArrayList<>();
                userSavePinService.findAllByUser(user).forEach(e -> {
                    pins.add(e.getPin());
                });
                Collections.reverse(pins);
                List<Pins> result = pins.subList(pins.size() - 3, pins.size());
                detailService.initDetailNotifications(notifications.getId(), result);
                break;
            case Friend:
                break;
            case Comment:
                break;
            case Like:
                break;
            default:
                System.out.println("Cannot init notifications with this type");
        }
        // Gửi lại danh sách các thông báo mới
        List<Notifications> result = getNotifications(userId);
        System.out.println("===========:"+result);
        sendNotifications(result, userId);
    }

    @PostMapping("/deleted/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.deleteById(id);
    }

    @Scheduled(fixedDelay = 100)
    public void send() {
        if (service.checkNotificationChange(1)) {
            messagingTemplate.convertAndSend("/room/messenger/{userId}", getNotifications(1));
        }
    }

}
