package com.socialmedia.service;

import com.socialmedia.model.Report_Pins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.repository.Report_PinRepository;
import java.util.List;

@Service
public class Report_PinServiceImpl implements Report_PinService {

    @Autowired
    private Report_PinRepository repository;

    public Report_Pins saveReportPins(Report_Pins reportPin) {
        return repository.save(reportPin);
    }
    public List<Report_Pins> getAllReportPin() {
        return repository.findAll();
    }
}
