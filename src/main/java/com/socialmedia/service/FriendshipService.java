package com.socialmedia.service;

import com.socialmedia.model.Friendships;
import java.util.List;
import com.socialmedia.model.Users;
import java.util.Optional;

public interface FriendshipService {

    public List<Friendships> getAllByUser1AndStatus(Users user, Friendships.FriendshipStatus status);

    public List<Friendships> getAllByUser2AndStatus(Users user, Friendships.FriendshipStatus status);

    public List<Friendships> getAllByUser1(Users user);

    public List<Friendships> getAllByUser2(Users user);
    
    public Friendships getOneByUser1AndUser2(Users user1, Users user2);

    public Optional<Friendships> getById(int id);

    public Friendships save(Friendships friendship);
    
     public boolean delete(int id);

}
