package com.socialmedia.repository;

import com.socialmedia.model.Boards;
import org.springframework.data.jpa.repository.JpaRepository;

import com.socialmedia.model.UserSavePin;
import com.socialmedia.model.Users;
import java.util.List;

public interface UserSavePinRepository extends JpaRepository<UserSavePin, Integer> {

    public List<UserSavePin> findAllByUserAndBoard(Users user, Boards board);
}