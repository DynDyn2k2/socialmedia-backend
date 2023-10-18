package com.socialmedia.service;

import com.socialmedia.model.Boards;
import java.util.List;

import com.socialmedia.model.UserSavePin;
import com.socialmedia.model.Users;

public interface UserSavePinService {

    public UserSavePin saveUserSavePin(UserSavePin userSavePin);

    public List<UserSavePin> getAllUserSavePin();

    public List<UserSavePin> findAllByUserAndBoard(Users user, Boards board);
}
