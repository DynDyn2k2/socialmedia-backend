package com.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.model.Pins;
import com.socialmedia.repository.PinRepository;

@Service
public class PinServiceImpl implements PinService {

    @Autowired
    private PinRepository repository;

    @Override
    public List<Pins> getPinsByUserId(int userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Pins> getAllPins() {
        // TODO Auto-generated method stub
        return repository.findAll();
    }

}