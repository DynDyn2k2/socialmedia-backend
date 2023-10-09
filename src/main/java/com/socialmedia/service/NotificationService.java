package com.socialmedia.service;

import java.util.List;

import com.socialmedia.model.Notifications;

public interface NotificationService {

    public Notifications saveNotifications(Notifications not);

    public List<Notifications> getAllNotifications();

}
