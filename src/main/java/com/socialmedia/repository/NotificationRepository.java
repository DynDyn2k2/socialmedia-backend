package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.model.Notifications;

public interface NotificationRepository extends JpaRepository<Notifications, Integer> {

}
