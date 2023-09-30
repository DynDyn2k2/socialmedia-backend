package com.socialmedia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Participants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int participantId;
    
    @ManyToOne
    @JoinColumn(name="conversationId")  
    private Conversations conversation;
 
    @ManyToOne
    @JoinColumn(name="userId")  
    private Users user;

    private String role;
    
}