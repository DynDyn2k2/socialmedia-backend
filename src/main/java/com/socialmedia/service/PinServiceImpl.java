package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Pins;
import com.socialmedia.repository.PinRepository;

@Service
public class PinServiceImpl implements PinService {

    @Autowired
    private PinRepository  repository;


}