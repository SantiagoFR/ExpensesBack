package com.autentia.expensesapplication.service;

import com.autentia.expensesapplication.entities.Friend;
import com.autentia.expensesapplication.repository.FriendsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsService {

    private FriendsRepository friendsRepository;

    public FriendsService(FriendsRepository friendsRepository) {
        this.friendsRepository = friendsRepository;
    }

    public List<Friend> findAll() {
        return friendsRepository.findAll();
    }

    public void addFriend(Friend friend) { friendsRepository.addFriend(friend); }
}
