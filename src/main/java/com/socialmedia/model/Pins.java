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

    private String image;
    private String description;
    private Date link;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pinId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Boards board;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Types type;

}