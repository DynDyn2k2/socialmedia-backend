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
        return repository.findAll();
    }

    @Override
    public List<Messages> getAllMessagesByConversationId(int id) {
        return repository.findByConversationId(id);
    }

    @Override
    public Messages saveMessage(Messages message) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}