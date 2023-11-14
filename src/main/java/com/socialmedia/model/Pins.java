package com.socialmedia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.sql.Blob;
import java.util.Date;

@Entity
public class Pins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name="userId")  
    private Users user;

   
    @ManyToOne
    @JoinColumn(name="boardId")  
    private Boards board;
    private String image;
    private String title;
    private String description;
    private String link;
 
    @ManyToOne
    @JoinColumn(name="typeId")  
    private Types type;
    
    private Date created_at;

   
    
    public Pins() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
           return image;
       }

    public void setImage(String image) {
        this.image = image;
    }
    
    public Boards getBoard() {
        return board;
    }

    public void setBoard(Boards board) {
        this.board = board;
    }
    
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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


    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }
    
    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    
}