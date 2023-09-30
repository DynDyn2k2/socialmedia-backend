package com.socialmedia.repository;

import com.socialmedia.model.Friendships;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRepository extends JpaRepository<Friendships,Integer> {


}