package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Types;
import com.socialmedia.repository.TypeRepository;

@Service
public class TypeServiceImpl implements BoardService {

    @Autowired
    private TypeRepository  repository;


}