package com.socialmedia.service;

import com.socialmedia.model.Comments;
import com.socialmedia.model.Pins;
import java.util.Date;
import java.util.List;

public interface CommentService {

    public List<Comments> getAll();

    public Comments saveComment(Comments comment);

    public boolean delete(int cmt_id);

    public List<Comments> findAllByPin(Pins pin);

    public long countAll();

    public long countByCreatedAtBefore(Date date);

    public long countByCreatedAt(Date date);

    public long countByCreatedAt(Date date1, Date date2);
}
