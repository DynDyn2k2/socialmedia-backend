package com.socialmedia.repository;

import com.socialmedia.model.Report_Comments;
import com.socialmedia.model.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Report_CommentRepository extends JpaRepository<Report_Comments, Integer> {

    public long countByUserRatify(Users userRatify);

    public long countByApprove(boolean approve);

}
