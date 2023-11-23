package com.socialmedia.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.model.Notifications;
import com.socialmedia.model.Users;
import com.socialmedia.model.enums.Notification_TYPE;
import com.socialmedia.repository.NotificationRepository;
import com.socialmedia.repository.UserRepository;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository repository;
    @Autowired
    private UserRepository userRepository;

    private Long prevCount;

    @Override
    public List<Notifications> getNotificationsByUser(int userId) {
        // TODO Auto-generated method stub
        Optional<Users> user = userRepository.findById(userId);
        return repository.findByUser(user.get());
    }

    @Override
    public Notifications initNotifications(Notification_TYPE type, int userId) {
        Notifications notifications = new Notifications();
        notifications.setNotificationType(type);
        notifications.setNotification_at(new Date());
        List<Notifications> list = repository.findAll();
        notifications.setId((int) list.size() + 1);
        Users user = userRepository.findById(userId).get();
        notifications.setUser(user);
        return notifications;
    }

    @Override
    public Notifications getById(int id) {
        Optional<Notifications> optionalNot = repository.findById(id);
        if (optionalNot.isPresent()) {
            Notifications not = optionalNot.get();
            return not;
        }
        return null;
    }

}