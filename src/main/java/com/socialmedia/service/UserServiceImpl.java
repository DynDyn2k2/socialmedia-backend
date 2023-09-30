package com.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Users;
import com.socialmedia.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository  repository;

    @Override
    public Users saveUser(Users user) {
        return  repository.save(user);
    }


    @Override
    public List<Users> getAllUser() {
       return  repository.findAll();
    }
}