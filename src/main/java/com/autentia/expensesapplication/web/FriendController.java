package com.autentia.expensesapplication.web;

import com.autentia.expensesapplication.entities.Friend;
import com.autentia.expensesapplication.service.FriendService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
public class FriendController {

    private FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping(value = "/friends")
    public List<Friend> findAll() {
        return friendService.findAll();
    }

    @PostMapping(value = "/friends")
    public ResponseEntity<String> addFriend(
            @RequestBody Friend friend) {
        friendService.addFriend(friend);
        return new ResponseEntity<String>(HttpStatus.OK);

    }

}
