package com.socialmedia.repository;

import com.socialmedia.model.Users;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {

    public Users findOneByUsername(String Username);
    public Users findOneByPassword(String password);

    
    public long countByCreatedAtBefore(Date created_at);    

}