package com.autentia.expensesapplication.repository;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.mapper.ExpenseRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpensesRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Expense> findAll() {
        return jdbcTemplate.query("SELECT * FROM expenses.expenses", new ExpenseRowMapper());
    }
}
