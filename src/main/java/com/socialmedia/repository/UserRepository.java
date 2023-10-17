package com.socialmedia.repository;

import com.socialmedia.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {

    public Users findOneByUsername(String Username);

}