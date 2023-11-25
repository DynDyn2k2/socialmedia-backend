package com.socialmedia.repository;

import com.socialmedia.model.Likes;
import com.socialmedia.model.Pins;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeRepository extends JpaRepository<Likes, Integer> {

    public List<Likes> findAllByPin(Pins pin);
    
    public long countByCreatedAtBefore(Date created_at);    

    @Query("SELECT COUNT(e) FROM Likes e WHERE DATE_FORMAT(e.createdAt, '%Y-%m-%d') = :formattedDate")
    long countByCreatedAt(@Param("formattedDate") String formattedDate);

    @Query("SELECT COUNT(e) FROM Likes e WHERE DATE_FORMAT(e.createdAt, '%Y-%m-%d') >= :date1 AND DATE_FORMAT(e.createdAt, '%Y-%m-%d') <= :date2")
    long countByCreatedAt(@Param("date1") String date1, @Param("date2") String date2);
}
