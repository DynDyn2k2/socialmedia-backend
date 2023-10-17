package com.socialmedia.controller;

import com.socialmedia.model.Friendships;
import com.socialmedia.service.FriendshipService;
import com.socialmedia.service.UserService;
import java.util.Optional;
import com.socialmedia.model.Users;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friendships")
@CrossOrigin
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;
    
    @Autowired
    private UserService userService;

    @GetMapping(value = {"/{id}"})
    public int countFriend(@PathVariable("id") int id) {
        Optional<Users> optional1 = userService.getUserById(id);
        Users user1 = optional1.get();
        Friendships.FriendshipStatus status1 = Friendships.FriendshipStatus.ACCEPTED;
        List<Friendships> list1 = friendshipService.getAllByUser1AndStatus(user1, status1);
        
        Optional<Users> optional2 = userService.getUserById(id);
        Users user2 = optional2.get();
        Friendships.FriendshipStatus status2 = Friendships.FriendshipStatus.ACCEPTED;
        List<Friendships> list2 = friendshipService.getAllByUser2AndStatus(user2, status2);
        
        
        return list1.size()+list2.size();
    }
}
