package com.socialmedia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.model.Pins;

public interface PinRepository extends JpaRepository<Pins, Integer> {
    List<Pins> findByUserId(int userId);
}