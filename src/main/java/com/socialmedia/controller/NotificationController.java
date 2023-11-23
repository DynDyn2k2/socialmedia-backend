package com.socialmedia.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.model.Friendships;
import com.socialmedia.model.Notifications;
import com.socialmedia.model.Pins;
import com.socialmedia.model.SendEntity;
import com.socialmedia.repository.NotificationRepository;
import com.socialmedia.service.DetailNotificationService;
import com.socialmedia.service.NotificationService;
import com.socialmedia.service.PinService;
import com.socialmedia.service.UserSavePinService;
import com.socialmedia.service.UserService;

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

    @Autowired
    private PinService pinService;

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

    @MessageMapping("sendNot/{userId}")
    @SendTo("/room/updateNots/{userId}")
    public SendEntity initNotifications(@Payload SendEntity variable, @DestinationVariable int userId) {
        Notifications notifications = service.initNotifications(variable.getNotifications().getNotificationType(),
                userId);
        repository.save(notifications);
        switch (variable.getNotifications().getNotificationType()) {
            case Pin:
                // Trả về thông báo vừa được tạo
                if (notifications != null) {
                    if (variable.getListPins() != null) {
                        List<Pins> list = new ArrayList<>();
                        variable.getListPins().forEach(e -> {
                            list.add(pinService.getPinById(e.getId()).get());
                        });
                        detailService.initDetailNotifications(notifications, list, userId);
                    }
                }
            case Friend:
                if (variable.getFriendships() != null) {
                    Friendships friendships = variable.getFriendships();
                    friendships.setCreated_at(new Date());
                }
                break;
            case Comment:
                break;
            case Like:
                break;
            default:
                System.out.println("Cannot initial notifications !!!");
                break;
        }
        System.out.println("Init " + notifications.getNotificationType() + " notification success !!!");
        variable.setNotifications(notifications);
        return variable;
    }

    @PostMapping("/deleted/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.deleteById(id);
    }

}