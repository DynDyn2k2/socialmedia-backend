package com.socialmedia.service;

import java.util.List;

import com.socialmedia.model.Pins;

public interface PinService {
    public List<Pins> getPinsByUserId(int userId);

    public List<Pins> getAllPins();
}
