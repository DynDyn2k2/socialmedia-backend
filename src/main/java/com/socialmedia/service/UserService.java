package com.socialmedia.service;

import java.util.List;
import com.socialmedia.model.Users;
import java.util.Optional;

public interface UserService {
    public Users saveUser(Users user);
    public List<Users> getAllUsers();
    public Users getUserByUsername(String username);
    public Optional<Users> getUserById(int id);
    
}
