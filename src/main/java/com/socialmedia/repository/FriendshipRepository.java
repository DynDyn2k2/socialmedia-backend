package com.socialmedia.repository;

import com.socialmedia.model.Friendships;
import java.util.List;
import com.socialmedia.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRepository extends JpaRepository<Friendships, Integer> {

    public List<Friendships> findAllByUser1AndStatus(Users user, Friendships.FriendshipStatus status);

    public List<Friendships> findAllByUser2AndStatus(Users user, Friendships.FriendshipStatus status);
    
      public List<Friendships> findAllByUser1(Users user);

    public List<Friendships> findAllByUser2(Users user);
}
