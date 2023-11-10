package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.repository.Report_PinRepository;

@Service
public class Report_PinServiceImpl implements Report_PinService {

    @Autowired
    private Report_PinRepository repository;

    
}
