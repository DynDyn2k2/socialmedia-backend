package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.UserFollowBoard;
import com.socialmedia.repository.UserFollowBoardRepository;

@Service
public class UserFollowBoardServiceImpl implements UserFollowBoardService {

    @Autowired
    private UserFollowBoardRepository  repository;


}