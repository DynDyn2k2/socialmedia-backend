package com.socialmedia.service;

import com.socialmedia.model.DetailNotification;
import com.socialmedia.model.Pins;
import java.util.List;

public interface DetailNotificationService {
         
    public List<DetailNotification> findAllByPin(Pins pin);
    
    public boolean delete(int id);
    
}
