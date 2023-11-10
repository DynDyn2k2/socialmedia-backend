package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Friendships;
import com.socialmedia.repository.FriendshipRepository;
import java.util.List;
import com.socialmedia.model.Users;

@Service
public class FriendshipServiceImpl implements FriendshipService {

    @Autowired
    private FriendshipRepository  repository;

    @Override
    public List<Friendships> getAllByUser1AndStatus(Users user, Friendships.FriendshipStatus status) {
       return repository.findAllByUser1AndStatus(user, status);
    }

    @Override
    public List<Friendships> getAllByUser2AndStatus(Users user, Friendships.FriendshipStatus status) {
        return repository.findAllByUser2AndStatus(user, status);
    }

    @Override
    public List<Friendships> getAllByUser1(Users user) {
        return repository.findAllByUser1(user);
    }

    @Override
    public List<Friendships> getAllByUser2(Users user) {
       return repository.findAllByUser2(user);
    }
}