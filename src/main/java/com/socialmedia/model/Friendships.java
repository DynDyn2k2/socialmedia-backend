package com.socialmedia.model;

import jakarta.persistence.Column;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Friendships {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int friendshipId;
    
    @ManyToOne
    @JoinColumn(name="userId1")  
    private Users user1;
    
    @ManyToOne
    @JoinColumn(name="userId2")  
    private Users user2;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FriendshipStatus status;
    private Date created_at;

    
}
enum FriendshipStatus {
    PENDING,
    ACCEPTED,
    REJECTED
}