package com.socialmedia.repository;

import com.socialmedia.model.Comments;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments,Integer> {
    List<Comments> findByPinId(int pin_id);
}