package com.socialmedia.repository;

import com.socialmedia.model.Boards;
import com.socialmedia.model.Pins;
import com.socialmedia.model.Users;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PinRepository extends JpaRepository<Pins, Integer> {

    public List<Pins> findByUserOrderByIdAsc(Users user);

    public List<Pins> findPinsByTypeId(Long typeId);

    public List<Pins> findByUser(Optional<Users> user);
    
        public long countByCreatedAtBefore(Date created_at);    

}
