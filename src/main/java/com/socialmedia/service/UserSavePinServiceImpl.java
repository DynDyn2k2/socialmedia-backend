package com.socialmedia.service;

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

}