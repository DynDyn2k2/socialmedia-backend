package com.socialmedia.repository;

import com.socialmedia.model.Likes;
import com.socialmedia.model.Pins;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Likes, Integer> {

    public List<Likes> findAllByPin(Pins pin);
    
        public long countByCreatedAtBefore(Date created_at);    
}
