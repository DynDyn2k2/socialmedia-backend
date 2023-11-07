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
public class TempUser {
    private Integer id;
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

    public TempUser(Integer id, String username, String password, Date birthdate, String fullname, String introduce, String avatar, String website, String gender, String language, boolean privateBool) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
        this.fullname = fullname;
        this.introduce = introduce;
        this.avatar = avatar;
        this.website = website;
        this.gender = gender;
        this.language = language;
        this.privateBool = privateBool;
    }

    public TempUser(TempUser user) {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.birthdate = user.birthdate;
        this.fullname = user.fullname;
        this.introduce = user.introduce;
        this.avatar = user.avatar;
        this.website = user.website;
        this.gender = user.gender;
        this.language = user.language;
        this.privateBool = user.privateBool;
    }

    public TempUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isPrivateBool() {
        return privateBool;
    }

    public void setPrivateBool(boolean privateBool) {
        this.privateBool = privateBool;
    }
    
}
