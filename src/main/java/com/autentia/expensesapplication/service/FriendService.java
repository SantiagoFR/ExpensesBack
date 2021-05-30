package com.autentia.expensesapplication.service;

import com.autentia.expensesapplication.entities.Friend;
import com.autentia.expensesapplication.repository.FriendRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    private FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public List<Friend> findAll() {
        return friendRepository.findAll();
    }

    public void addFriend(Friend friend) { friendRepository.addFriend(friend); }
}
