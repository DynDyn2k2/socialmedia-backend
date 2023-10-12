package com.socialmedia.service;

import java.util.List;
import java.util.Optional;

import com.socialmedia.model.Pins;
import com.socialmedia.model.Users;

public interface PinService {
    // public List<Pins> getPinsByUserId(int userId);

    public List<Pins> getAllPins();

    public List<Pins> getPinsByTypeId(Long param);

    public List<Pins> getPinsByUserCreated(Optional<Users> user);

}
