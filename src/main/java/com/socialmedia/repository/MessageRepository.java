package com.socialmedia.repository;

import com.socialmedia.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Messages,Integer> {


}