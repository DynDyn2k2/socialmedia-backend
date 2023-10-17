package com.socialmedia.model;

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
    private String title;
    private String description;
    private String link;
 
    @ManyToOne
    @JoinColumn(name="boardId")  
    private Boards board;
    
    @ManyToOne
    @JoinColumn(name="typeId")  
    private Types type;

    public Pins() {
    }

    public int getPinId() {
        return pinId;
    }

    public void setPinId(int pinId) {
        this.pinId = pinId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boards getBoard() {
        return board;
    }

    public void setBoard(Boards board) {
        this.board = board;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    
}