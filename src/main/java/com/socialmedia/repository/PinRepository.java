package com.socialmedia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.model.Pins;
import com.socialmedia.model.Users;

public interface PinRepository extends JpaRepository<Pins, Integer> {
    // List<Pins> findByUserId(int userId);
    // @Query("SELECT p FROM Pins p WHERE b.type.typeId = :typeId")
    List<Pins> findPinsByTypeId(Long typeId);

    List<Pins> findByUserCreated(Optional<Users> user);
}