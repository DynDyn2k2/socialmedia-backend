package com.socialmedia.service;

import com.socialmedia.model.Types;
import java.util.List;
import java.util.Optional;

public interface TypeService {

    public List<Types> getAllTypes();
    
    public Types saveType(Types type);
    
    public Optional<Types> findById(int id);
    
}
