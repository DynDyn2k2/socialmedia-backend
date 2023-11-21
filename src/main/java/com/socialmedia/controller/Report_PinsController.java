/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.socialmedia.controller;

import com.socialmedia.model.Report_Pins;
import com.socialmedia.service.Report_PinService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author phmlhuyntrang
 */

@RestController
@RequestMapping("/report_pins")
@CrossOrigin
public class Report_PinsController {
    
    @Autowired
    private Report_PinService reportPinservice;

    
    @GetMapping(value = "/getAll")
    public List<Report_Pins> getAllReportPins() {
        return reportPinservice.getAllReportPin();
    }
    
    @PostMapping("/add")
    public boolean saveReport(@RequestBody Report_Pins reportPin) {
        reportPinservice.saveReportPins(reportPin);
        return true;
    }
}
