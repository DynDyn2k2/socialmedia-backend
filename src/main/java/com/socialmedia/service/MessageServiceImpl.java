package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Messages;
import com.socialmedia.repository.MessageRepository;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository  repository;

    @Override
    public List<Messages> getAll() {
//        java.sql.Types.
        return repository.findAll();
    }

    @Override
    public List<Messages> getAllMessagesByConversationId(int id) {
        return repository.findByConversationId(id);
    }

    @Override
    public Messages saveMessage(Messages message) {
        return repository.save(message);
    }

    @Override
    public Messages getMessageById(int id) {
        return repository.findById(id).get();
    }


}