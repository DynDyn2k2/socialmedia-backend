package com.socialmedia.service;

import com.socialmedia.model.Comments;
import com.socialmedia.model.Pins;
import java.util.Date;
import java.util.List;

public interface CommentService {

    public List<Comments> findAllByPin(Pins pin);

    public boolean delete(int id);

    public long countAll();

    public long countByCreatedAtBefore(Date date);
}
