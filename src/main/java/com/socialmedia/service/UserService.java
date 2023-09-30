package com.socialmedia.service;

import java.util.List;
import com.socialmedia.model.Users;

public interface UserService {
    public Users saveUser(Users user);
    public List<Users> getAllUser();
    
}
