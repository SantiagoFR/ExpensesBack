package com.autentia.expensesapplication.mapper;

import com.autentia.expensesapplication.entities.Friend;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FriendRowMapper implements RowMapper<Friend> {

    @Override
    public Friend mapRow(ResultSet rs, int rowNum) throws SQLException {
        Friend friend =  new Friend();
        friend.setId(rs.getLong("id"));
        friend.setFirstname(rs.getString("firstname"));
        friend.setLastname(rs.getString("lastname"));
        return friend;
    }
}
