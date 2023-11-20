package com.socialmedia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.model.Report_Pins;
import com.socialmedia.repository.Report_PinRepository;
import com.socialmedia.service.Report_PinService;

@RestController
@RequestMapping("/report_pins")
@CrossOrigin
public class ReportPinController {
    @Autowired
    private Report_PinRepository reportPinRepository;
    @Autowired
    private Report_PinService reportPinService;

    @GetMapping("/get")
    public ResponseEntity<List<Object[]>> getPins() {
        try {
            List<Object[]> pins = reportPinRepository.findAllWithDetails();
            return new ResponseEntity<>(pins, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // New endpoint to fetch details for a specific ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Object[]> getCommentById(@PathVariable int id) {
        try {
            Object[] commentDetails = reportPinRepository.findDetailsById(id);
            return new ResponseEntity<>(commentDetails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/id/{id}/{approveState}")
    public ResponseEntity<String> changeApproveState(
            @PathVariable("id") int id,
            @PathVariable("approveState") Boolean approveState) {

        try {
            reportPinService.changeApprove(id, approveState);
            return new ResponseEntity<>("Approve State changed successfully", HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to change approve state " + e.getMessage());
        }

    }
}
