package com.socialmedia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;
    
    @ManyToOne
    @JoinColumn(name="userId")  
    private Users user;
 
    @ManyToOne
    @JoinColumn(name="pinId")  
    private Pins pin;

    
}