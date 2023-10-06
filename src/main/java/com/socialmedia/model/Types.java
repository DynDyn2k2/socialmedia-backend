package com.socialmedia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;   
          
    private String typeName;
    
}