package com.socialmedia.repository;

import com.socialmedia.model.Boards;
import com.socialmedia.model.Pins;
import com.socialmedia.model.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PinRepository extends JpaRepository<Pins, Integer> {

    public List<Pins> findByUserOrderByPinIdAsc(Users user);

    public List<Pins> findAllByBoard(Boards board);
}
