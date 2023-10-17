package com.socialmedia.service;

import com.socialmedia.model.Boards;
import com.socialmedia.model.Pins;
import com.socialmedia.model.Users;
import java.util.List;

public interface PinService {

    public List<Pins> findByUserOrderByPinIdAsc(Users user);

    public List<Pins> findAllByBoard(Boards board);
}
