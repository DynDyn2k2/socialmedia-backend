package com.socialmedia.model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String password;
    private Date birthdate;
    private String fullname;
    private String introduce;
    private String avatar;
    private String website;
    private String gender;
    private String language;
    private boolean privateBool;
 


    
}