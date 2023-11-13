package com.socialmedia.controller;

import com.socialmedia.model.Friendships;
import com.socialmedia.service.FriendshipService;
import com.socialmedia.service.UserService;
import java.util.Optional;
import com.socialmedia.model.Users;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friendships")
@CrossOrigin
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/count/{id}"})
    public int countFriend(@PathVariable("id") int id) {
        Optional<Users> optional1 = userService.getUserById(id);
        Users user1 = optional1.get();
        Friendships.FriendshipStatus status1 = Friendships.FriendshipStatus.ACCEPTED;
        List<Friendships> list1 = friendshipService.getAllByUser1AndStatus(user1, status1);

        Optional<Users> optional2 = userService.getUserById(id);
        Users user2 = optional2.get();
        Friendships.FriendshipStatus status2 = Friendships.FriendshipStatus.ACCEPTED;
        List<Friendships> list2 = friendshipService.getAllByUser2AndStatus(user2, status2);

        return list1.size() + list2.size();
    }

    @GetMapping(value = {"/listFriend/{id}"})
    public List<Friendships> listFriend(@PathVariable("id") int id) {
        List<Friendships> list = new ArrayList<>();

        Optional<Users> optional1 = userService.getUserById(id);
        Users user1 = optional1.get();
        Friendships.FriendshipStatus status1 = Friendships.FriendshipStatus.ACCEPTED;
        List<Friendships> list1 = friendshipService.getAllByUser1AndStatus(user1, status1);
        list.addAll(list1);
//        for (Friendships friendships : list1) {
//            listUser.add(friendships.getUser2());
//        }
        Optional<Users> optional2 = userService.getUserById(id);
        Users user2 = optional2.get();
        Friendships.FriendshipStatus status2 = Friendships.FriendshipStatus.ACCEPTED;
        List<Friendships> list2 = friendshipService.getAllByUser2AndStatus(user2, status2);
        list.addAll(list2);
//        for (Friendships friendships : list2) {
//            listUser.add(friendships.getUser1());
//        }

        return list;
    }

    @GetMapping(value = {"/listRequest/{id}"})
    public List<Friendships> listRequest(@PathVariable("id") int id) {
        List<Friendships> list = new ArrayList<>();

        Optional<Users> optional1 = userService.getUserById(id);
        Users user1 = optional1.get();
        Friendships.FriendshipStatus status1 = Friendships.FriendshipStatus.PENDING;
        List<Friendships> list1 = friendshipService.getAllByUser1AndStatus(user1, status1);
        list.addAll(list1);
//        for (Friendships friendships : list1) {
//            listUser.add(friendships.getUser2());
//        }

        Optional<Users> optional2 = userService.getUserById(id);
        Users user2 = optional2.get();
        Friendships.FriendshipStatus status2 = Friendships.FriendshipStatus.PENDING;
        List<Friendships> list2 = friendshipService.getAllByUser2AndStatus(user2, status2);
        list.addAll(list2);
//        for (Friendships friendships : list2) {
//            listUser.add(friendships.getUser1());
//        }

        return list;
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Friendships> update(@PathVariable("id") int id, @RequestBody Friendships friendship) {
        Optional<Friendships> optionalFriendship = friendshipService.getById(id);

        if (optionalFriendship.isPresent()) {
            Friendships currentFriendship = optionalFriendship.get();
            currentFriendship.setStatus(friendship.getStatus());
            return new ResponseEntity<>(friendshipService.save(friendship), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id) {
        Optional<Friendships> optional = friendshipService.getById(id);   
        if (optional.isPresent()) {         
            return friendshipService.delete(id);
        } else {
            return false;
        }
    }

}
