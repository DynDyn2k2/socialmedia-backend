package com.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.model.UserSavePin;

public interface UserSavePinRepository extends JpaRepository<UserSavePin, Integer> {

}