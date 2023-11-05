package com.socialmedia.service;

import com.socialmedia.model.Messages;
import java.util.List;

public interface MessageService {
    List<Messages> getAll();
    List<Messages> getAllMessagesByConversationId(int id);
    Messages getMessageById(int id);
    Messages saveMessage(Messages message);
//    List<Messages>
}
