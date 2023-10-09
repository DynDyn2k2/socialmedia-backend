package com.socialmedia.service;

import java.util.List;

import com.socialmedia.model.UserSavePin;

public interface UserSavePinService {

    public UserSavePin saveUserSavePin(UserSavePin userSavePin);

    public List<UserSavePin> getAllUserSavePin();
}
