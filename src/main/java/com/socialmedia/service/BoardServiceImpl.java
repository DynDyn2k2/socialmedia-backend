package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository repository;

}