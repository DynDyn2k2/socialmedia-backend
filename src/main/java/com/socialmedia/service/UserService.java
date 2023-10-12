package com.socialmedia.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import com.socialmedia.model.Users;

public interface UserService {
    public Users saveUser(Users user);

    public List<Users> getAllUser();

    public Optional<Users> getUserById(int userId);

    public void loadData(String filPath) throws FileNotFoundException;

}
