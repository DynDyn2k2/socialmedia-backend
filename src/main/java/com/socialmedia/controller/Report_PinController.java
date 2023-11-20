package com.socialmedia.controller;

import com.socialmedia.model.ResultReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.service.Report_PinService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/report_pins")
@CrossOrigin
public class Report_PinController {

    @Autowired
    private Report_PinService service;

    @GetMapping("/count")
    public Object count() {
        long countAll = service.countAll();

        long countNotApprovedYet = service.countByUserRatify(null);

        long countApprove = service.countByApprove(true);

        ResultReport r = new ResultReport();
        r.countAll = countAll;
        r.countNotApprovedYet = countNotApprovedYet;
        r.countApprove = countApprove;
        return r;
    }

}
