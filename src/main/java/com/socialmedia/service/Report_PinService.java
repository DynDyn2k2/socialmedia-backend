package com.socialmedia.service;

import com.socialmedia.model.Report_Pins;
import java.util.List;

public interface Report_PinService {
    
    public Report_Pins saveReportPins(Report_Pins reportPin);

    public List<Report_Pins> getAllReportPin();

}
