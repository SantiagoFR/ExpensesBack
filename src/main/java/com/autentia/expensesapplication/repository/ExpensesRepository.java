package com.autentia.expensesapplication.repository;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.mapper.ExpenseRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ExpensesRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Expense> findAll() {
        return jdbcTemplate.query("SELECT * FROM expenses.expenses", new ExpenseRowMapper());
    }

    public void addExpense(Expense expense) {
        jdbcTemplate.update("INSERT INTO expenses.expenses (author, amount, description, date) VALUE (?,?,?,?)",
                expense.getAuthor(), expense.getAmount(), expense.getDescription(), expense.getDate());
    }

    public Expense getExpense(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM expenses.expenses WHERE id = ?", new Object[] { id }, new ExpenseRowMapper());
    }

    public void updateExpense(int id, Expense expense) {
        jdbcTemplate.update("UPDATE expenses.expenses SET author = ?, amount = ?, description = ?, date = ? WHERE id = ?",
                expense.getAuthor(), expense.getAmount(), expense.getDescription(), expense.getDate(), id);
    }

    public Map<String, Float> getBalance() {
        List<Expense> expenses = jdbcTemplate.query("SELECT * FROM expenses.expenses", new ExpenseRowMapper());
        Map<String, Float> balance = new HashMap<>();
        for (Expense expense: expenses) {
            if (balance.containsKey(expense.getAuthor())) {
                balance.replace(expense.getAuthor(), expense.getAmount() + balance.get(expense.getAuthor()));
            } else {
                balance.put(expense.getAuthor(), expense.getAmount());
            }
        }
        return balance;
    }
}
