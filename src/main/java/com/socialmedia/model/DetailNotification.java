package com.socialmedia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DetailNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailNotificationId;

    @ManyToOne
    @JoinColumn(name = "notificationId")
    private Notifications notification;

    @ManyToOne
    @JoinColumn(name = "pinId")
    private Pins pin;

}