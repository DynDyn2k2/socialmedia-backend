package com.socialmedia.repository;

import com.socialmedia.model.Report_Pins;
import com.socialmedia.model.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Report_PinRepository extends JpaRepository<Report_Pins, Integer> {

    public long countByUserRatify(Users userRatify);

    public long countByApprove(boolean approve);

}
