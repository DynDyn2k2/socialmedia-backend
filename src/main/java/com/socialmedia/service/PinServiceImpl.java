package com.socialmedia.service;

import com.socialmedia.model.Boards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Pins;
import com.socialmedia.model.Users;
import com.socialmedia.repository.PinRepository;
import java.util.List;

@Service
public class PinServiceImpl implements PinService {

    @Autowired
    private PinRepository  repository;

    @Override
    public List<Pins> findByUserOrderByPinIdAsc(Users user) {
       return repository.findByUserOrderByPinIdAsc(user);
    }

    @Override
    public List<Pins> findAllByBoard(Boards board) {
        return repository.findAllByBoard(board);
    }


}