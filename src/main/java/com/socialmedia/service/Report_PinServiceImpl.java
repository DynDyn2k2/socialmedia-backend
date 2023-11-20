package com.socialmedia.service;

import com.socialmedia.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.repository.Report_PinRepository;

@Service
public class Report_PinServiceImpl implements Report_PinService {

    @Autowired
    private Report_PinRepository repository;

    @Override
    public long countAll() {
        return repository.count();
    }

    @Override
    public long countByUserRatify(Users userRatify) {
        return repository.countByUserRatify(userRatify);
    }

    @Override
    public long countByApprove(boolean approve) {
        return repository.countByApprove(approve);
    }

}
