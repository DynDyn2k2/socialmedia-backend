package com.socialmedia.service;

import com.socialmedia.model.Boards;
import com.socialmedia.model.Pins;
import com.socialmedia.model.Users;
import java.util.List;
import java.util.Optional;

public interface PinService {

    public List<Pins> findByUserOrderByIdAsc(Users user);

    public List<Pins> getAllPins();

    public Optional<Pins> getPinById(int id);

    public List<Pins> getPinsByTypeId(Long param);

    public List<Pins> getPinsByUser(Optional<Users> user);
}
