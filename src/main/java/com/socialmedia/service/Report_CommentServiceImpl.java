package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.repository.Report_CommentRepository;

@Service
public class Report_CommentServiceImpl implements Report_CommentService {

    @Autowired
    private Report_CommentRepository repository;

    
}
