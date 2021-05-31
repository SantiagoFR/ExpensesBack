package com.autentia.expensesapplication.repository;

import com.autentia.expensesapplication.entities.Friend;
import com.autentia.expensesapplication.mapper.FriendRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FriendsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Friend> findAll() {
        return jdbcTemplate.query("SELECT * FROM expenses.friends", new FriendRowMapper());
    }

    public void addFriend(Friend friend) {
        jdbcTemplate.update("INSERT INTO expenses.friends (firstname, lastname) VALUES (?,?)",
                friend.getFirstname(), friend.getLastname());
    }


}
