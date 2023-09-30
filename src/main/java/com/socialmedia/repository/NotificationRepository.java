package com.socialmedia.repository;

import com.socialmedia.model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notifications,Integer> {


}