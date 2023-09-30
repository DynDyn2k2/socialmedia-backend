package com.socialmedia.model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pinId;
    
    @ManyToOne
    @JoinColumn(name="userId")  
    private Users user;
          
    private String image;
    private String description;
    private Date link;
 
    @ManyToOne
    @JoinColumn(name="boardId")  
    private Boards board;

    
}