package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.DetailNotification;
import com.socialmedia.repository.DetailNotificationRepository;

@Service
public class DetailNotificationServiceImpl implements DetailNotificationService {

    @Autowired
    private DetailNotificationRepository  repository;


}