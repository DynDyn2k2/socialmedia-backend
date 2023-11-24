package com.socialmedia.service;

import java.util.Date;
import java.util.List;

import com.socialmedia.model.Likes;
import com.socialmedia.model.Notifications;
import com.socialmedia.model.Pins;

public interface LikeService {

    public List<Likes> findAllByPin(Pins pin);

    public Likes getByNotification(Notifications notification);

    public boolean delete(int id);

    public long countAll();

    public long countByCreatedAtBefore(Date date);

    public long countByCreatedAt(Date date);

    public long countByCreatedAt(Date date1, Date date2);
}
