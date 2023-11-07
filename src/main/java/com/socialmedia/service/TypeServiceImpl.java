package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Types;
import com.socialmedia.repository.TypeRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository  repository;

    @Override
    public Optional<Types> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Types saveType(Types type) {
        return repository.save(type);
    }
    
    @Override
    public List<Types> getAllTypes() {
        return repository.findAll();
    }
}