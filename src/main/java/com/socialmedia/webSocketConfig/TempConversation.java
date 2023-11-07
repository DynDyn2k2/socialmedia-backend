/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socialmedia.webSocketConfig;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class TempConversation {
    private int id;
    private String name;
    private Date create_at;  

    public TempConversation(int id, String name, Date create_at) {
        this.id = id;
        this.name = name;
        this.create_at = create_at;
    }

    public TempConversation(TempConversation conversation) {
        this.id = conversation.getId();
        this.name = conversation.getName();
        this.create_at = conversation.getCreate_at();
    }

    public TempConversation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
    
}
