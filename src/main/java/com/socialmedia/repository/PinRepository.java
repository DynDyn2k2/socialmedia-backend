package com.socialmedia.repository;

import com.socialmedia.model.Pins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PinRepository extends JpaRepository<Pins,Integer> {


}