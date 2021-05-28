package com.autentia.expensesapplication.mapper;

import com.autentia.expensesapplication.entities.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExpenseRowMapper implements RowMapper<Expense> {

    @Override
    public Expense mapRow(ResultSet rs, int rowNum) throws SQLException {
        Expense expense =  new Expense();
        expense.setId(rs.getLong("id"));
        expense.setAuthor(rs.getString("author"));
        expense.setDescription(rs.getString("description"));
        expense.setDate(rs.getDate("date"));
        expense.setAmount(rs.getFloat("amount"));
        return expense;
    }
}
