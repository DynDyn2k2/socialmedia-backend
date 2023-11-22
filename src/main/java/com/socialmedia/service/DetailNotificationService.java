package com.socialmedia.service;

import java.util.List;

import com.socialmedia.model.DetailNotification;
import com.socialmedia.model.Pins;

public interface DetailNotificationService {

    public List<DetailNotification> findAllByPin(Pins pin);

    public List<Pins> getRelatedPins(int notificationId);

    public void initDetailNotifications(int notificationId, List<Pins> pins);

    public boolean delete(int id);

}
