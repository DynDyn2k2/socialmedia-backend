package com.socialmedia.service;

import com.socialmedia.model.Boards;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.model.UserSavePin;
import com.socialmedia.model.Users;
import com.socialmedia.repository.UserSavePinRepository;

@Service
public class UserSavePinServiceImpl implements UserSavePinService {

    @Autowired
    private UserSavePinRepository repository;

    @Override
    public UserSavePin saveUserSavePin(UserSavePin userSavePin) {
        return repository.save(userSavePin);
    }

    @Override
    public List<UserSavePin> getAllUserSavePin() {
        return repository.findAll();
    }

    @Override
    public List<UserSavePin> findAllByUserAndBoard(Users user, Boards board) {
        return repository.findAllByUserAndBoard(user, board);
    }

}