package com.autentia.expensesapplication.web;

import com.autentia.expensesapplication.entities.Friend;
import com.autentia.expensesapplication.service.FriendsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
public class FriendsController {

    private FriendsService friendsService;

    public FriendsController(FriendsService friendsService) {
        this.friendsService = friendsService;
    }

    @GetMapping(value = "/friends")
    public List<Friend> findAll() {
        return friendsService.findAll();
    }

    @PostMapping(value = "/friends")
    public ResponseEntity<String> addFriend(
            @RequestBody Friend friend) {
        friendsService.addFriend(friend);
        return new ResponseEntity<String>(HttpStatus.OK);

    }

}
