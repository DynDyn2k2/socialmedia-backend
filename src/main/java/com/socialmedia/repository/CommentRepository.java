package com.socialmedia.repository;

import com.socialmedia.model.Comments;
import com.socialmedia.model.Pins;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, Integer> {

    public List<Comments> findAllByPin(Pins pin);
    public List<Comments> findByPinId(int pin_id);
    public long countByCommentAtBefore(Date created_at);
}
