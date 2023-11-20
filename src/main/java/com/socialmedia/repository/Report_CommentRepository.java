package com.socialmedia.repository;

import com.socialmedia.model.Report_Comments;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface Report_CommentRepository extends JpaRepository<Report_Comments, Integer> {

    @Query("SELECT rc.id, c.content AS commentContent, cr.content AS reportContent, u.username, rc.approve, rc.reject " +
            "FROM Report_Comments rc " +
            "JOIN rc.comment c " +
            "JOIN rc.content cr " +
            "JOIN rc.userRatify u")
    List<Object[]> findAllWithDetails();

    @Query("SELECT rc.id, c.content AS commentContent, cr.content AS reportContent, u.username, rc.approve, rc.reject " +
           "FROM Report_Comments rc " +
           "JOIN rc.comment c " +
           "JOIN rc.content cr " +
           "JOIN rc.userRatify u " +
           "WHERE rc.id = :id")
    Object[] findDetailsById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE Report_Comments rc SET rc.approve = :approve, rc.reject = :reject WHERE rc.id = :id")
    void updateApprovalStatus(@Param("id") int id, @Param("approve") Boolean approve, @Param("reject") Boolean reject);
}
