package com.socialmedia.repository;

import com.socialmedia.model.Boards;
import com.socialmedia.model.Pins;
import com.socialmedia.model.Users;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PinRepository extends JpaRepository<Pins, Integer> {

    public List<Pins> findByUserOrderByIdAsc(Users user);

    public List<Pins> findPinsByTypeId(Long typeId);

    public List<Pins> findByUser(Optional<Users> user);

    public long countByCreatedAtBefore(Date created_at);

    @Query("SELECT COUNT(e) FROM Pins e WHERE DATE_FORMAT(e.createdAt, '%Y-%m-%d') = :formattedDate")
    long countByCreatedAt(@Param("formattedDate") String formattedDate);

    @Query("SELECT COUNT(e) FROM Pins e WHERE DATE_FORMAT(e.createdAt, '%Y-%m-%d') >= :date1 AND DATE_FORMAT(e.createdAt, '%Y-%m-%d') <= :date2")
    long countByCreatedAt(@Param("date1") String date1, @Param("date2") String date2);

}
