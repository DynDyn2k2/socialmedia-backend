package com.socialmedia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialmedia.model.Report_Comments;
import com.socialmedia.model.Users;
import com.socialmedia.repository.Report_CommentRepository;

import jakarta.persistence.EntityNotFoundException;



@Service
public class Report_CommentServiceImpl implements Report_CommentService {

    @Autowired
    private Report_CommentRepository repository;

    @Autowired
    public Report_CommentServiceImpl(Report_CommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void changeApprove(int id, boolean approveState) {
        Optional<Report_Comments> optional = repository.findById(id);
        if (optional.isPresent()) {
            Report_Comments rc = optional.get();
            if (rc.getApproval() == approveState) {
                System.out.println("Duyệt thành công" + rc.getApproval());
                rc.setApproval(approveState);
                rc.setReject(!approveState);
                repository.save(rc);
            }
            else {
                System.out.println("Duyệt không thành công"+ rc.getApproval());
                rc.setApproval(approveState);
                rc.setReject(!approveState);
                repository.save(rc);
            }
        } else {
            throw new EntityNotFoundException(" not found to set private");
        }
    }
}