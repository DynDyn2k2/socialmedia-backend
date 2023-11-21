package com.socialmedia.service;

import com.socialmedia.model.Users;
import com.socialmedia.model.Report_Pins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.repository.Report_PinRepository;
import java.util.List;

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

    @Override
    public Report_Pins saveReportPins(Report_Pins reportPin) {
        return repository.save(reportPin);
    }

    @Override
    public List<Report_Pins> getAllReportPin() {
        return repository.findAll();
    }

}
