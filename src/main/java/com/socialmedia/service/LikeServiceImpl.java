package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Likes;
import com.socialmedia.repository.LikeRepository;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository  repository;


}