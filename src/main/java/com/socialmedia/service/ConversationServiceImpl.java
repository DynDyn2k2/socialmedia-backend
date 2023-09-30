package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Conversations;
import com.socialmedia.repository.ConversationRepository;

@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired
    private ConversationRepository  repository;


}