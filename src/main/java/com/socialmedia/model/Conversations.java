package com.socialmedia.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Conversations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int conversationId;
    
    private String name;
    private String content;
    private Date create_at;   
    
}