package com.socialmedia.service;

import com.socialmedia.model.Friendships;
import java.util.List;
import com.socialmedia.model.Users;

public interface FriendshipService {

     public List<Friendships> getAllByUser1AndStatus(Users user, Friendships.FriendshipStatus status);
     public List<Friendships> getAllByUser2AndStatus(Users user, Friendships.FriendshipStatus status);
}
