package com.socialmedia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.model.Report_Pins;
import com.socialmedia.repository.Report_CommentRepository;
import com.socialmedia.repository.Report_PinRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Report_PinServiceImpl implements Report_PinService {

    @Autowired
    private Report_PinRepository repository;

    @Autowired
    public Report_PinServiceImpl(Report_PinRepository repository) {
        this.repository = repository;
    }

    @Override
    public void changeApprove(int id, boolean approveState) {
        Optional<Report_Pins> optional = repository.findById(id);
        if (optional.isPresent()) {
            Report_Pins rp = optional.get();
            if (rp.getApproval() == approveState) {
                System.out.println("Duyệt thành công" + rp.getApproval());
                rp.setApproval(approveState);
                rp.setReject(!approveState);
                repository.save(rp);
            } else {
                System.out.println("Duyệt không thành công" + rp.getApproval());
                rp.setApproval(approveState);
                rp.setReject(!approveState);
                repository.save(rp);
            }
        } else {
            throw new EntityNotFoundException(" not found to set private");
        }
    }
}
