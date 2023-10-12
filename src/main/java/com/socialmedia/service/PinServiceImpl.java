package com.socialmedia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.model.Pins;
import com.socialmedia.model.Users;
import com.socialmedia.repository.PinRepository;
import com.socialmedia.repository.UserRepository;

@Service
public class PinServiceImpl implements PinService {

    @Autowired
    private PinRepository repository;

    private UserRepository userRes;

    // @Override
    // public List<Pins> getPinsByUserId(int userId) {
    // return repository.findByUserId(userId);
    // }

    @Override
    public List<Pins> getPinsByTypeId(Long typeId) {
        return repository.findPinsByTypeId(typeId);
    }

    @Override
    public List<Pins> getAllPins() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

    @Override
    public List<Pins> getPinsByUserCreated(Optional<Users> user) {
        // TODO Auto-generated method stub
        return repository.findByUserCreated(user);
    }

}