package com.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.repository.Report_CommentRepository;
import com.socialmedia.service.Report_CommentService;

@RestController
@RequestMapping("/report_comments")
@CrossOrigin
public class Report_CommentController {
    @Autowired
    private Report_CommentRepository reportCommentRepository;
    @Autowired
    private Report_CommentService reportCommentService;

    @GetMapping("/get")
    public ResponseEntity<List<Object[]>> getComments() {
        try {
            List<Object[]> comments = reportCommentRepository.findAllWithDetails();
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object[]> getCommentById(@PathVariable int id) {
        try {
            Object[] commentDetails = reportCommentRepository.findDetailsById(id);
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
            reportCommentService.changeApprove(id, approveState);
            return new ResponseEntity<>("Approve State changed successfully", HttpStatus.OK);     

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to change approve state " + e.getMessage());
        }

    }
}

