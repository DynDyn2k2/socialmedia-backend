/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socialmedia.webSocketConfig;

import com.socialmedia.model.Conversations;
import com.socialmedia.model.Users;
import java.sql.Date;

/**
 *
 * @author PC
 */
public class TempMessage {

    private int id;

    private TempUser user;
 
    private String content;
//    public TempMessage(String content) {
//        this.content = content;
//    }
    public TempMessage(){};
    private Date send_at; 

    private TempConversation conversation;

    public TempMessage(int id, TempUser user, String content, Date send_at, TempConversation conversation) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.send_at = send_at;
        this.conversation = conversation;
    }
    
    public TempMessage(TempMessage message) {
        this.id = message.id;
        this.user = message.user;
        this.content = message.content;
        this.send_at = message.send_at;
        this.conversation = message.conversation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TempUser getUser() {
        return user;
    }

    public void setUser(TempUser user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSend_at() {
        return send_at;
    }

    public void setSend_at(Date send_at) {
        this.send_at = send_at;
    }

    public TempConversation getConversation() {
        return conversation;
    }

    public void setConversation(TempConversation conversation) {
        this.conversation = conversation;
    }
    
    
}
