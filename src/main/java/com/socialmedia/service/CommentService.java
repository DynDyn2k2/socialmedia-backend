package com.socialmedia.service;

import com.socialmedia.model.Comments;
import java.util.List;

public interface CommentService {
    List<Comments> getAll();
    List<Comments> getByPinId(int pin_id);
    Comments saveComment(Comments comment);
    boolean delete(int cmt_id);
}
