package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Boards;
import com.socialmedia.model.Users;
import com.socialmedia.repository.BoardRepository;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository  repository;

    @Override
    public List<Boards> findByUserOrderByIdAsc(Users user) {
        return repository.findByUserOrderByIdAsc(user);
    }

    @Override
    public Optional<Boards> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Boards saveBoard(Boards board) {
        return repository.save(board);
    }
}

