package com.socialmedia.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.socialmedia.model.Users;

public interface UserService {
    public Users saveUser(Users user);

    public List<Users> getAllUser();

    public void loadData(String filPath) throws FileNotFoundException;

}
