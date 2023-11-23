package com.socialmedia.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.model.Pins;
import com.socialmedia.model.Types;
import com.socialmedia.model.Users;

public interface PinRepository extends JpaRepository<Pins, Integer> {

    public List<Pins> findByUserOrderByIdAsc(Users user);

    List<Pins> findByType(Types type);

    public List<Pins> findByUser(Optional<Users> user);

    public long countByCreatedAtBefore(Date created_at);

}
