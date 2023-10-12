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
    private int id;

    public int getId() {
        return id;
    }

    private String description;
    private String image;
    private String link;

    // // Users_Save_Pins
    // @ManyToMany(mappedBy = "pins")
    // // mappedBy sẽ nối đến kết quả trả về từ quan hệ
    // private List<Users> users = new ArrayList<>();

    // public List<Users> getUsers() {
    // return users;
    // }

    // public void setUsers(List<Users> users) {
    // this.users = users;
    // }
    /* The end */

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Boards board;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Types type;

    // User_Created_Pin
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users userCreated;

    public Users getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Users userCreatedId) {
        this.userCreated = userCreatedId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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