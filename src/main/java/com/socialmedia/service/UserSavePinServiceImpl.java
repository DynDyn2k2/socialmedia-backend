package com.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.model.UserSavePin;
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

}