package com.socialmedia.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;
    
    @ManyToOne
    @JoinColumn(name="userId")  
    private Users user;
 
    private String title;
    private String link;
    private Date notification_at;
    
    @ManyToOne
    @JoinColumn(name="typeId")  
    private Types type;

    
}