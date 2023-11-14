package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Comments;
import com.socialmedia.repository.CommentRepository;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository  repository;

    @Override
    public List<Comments> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Comments> getByPinId(int pin_id) {
        return repository.findByPinId(pin_id);
    }

    @Override
    public Comments saveComment(Comments comment) {
        return repository.save(comment);
    }

    @Override
    public boolean delete(int cmt_id) {
        repository.deleteById(cmt_id);
        return true;
    }


}