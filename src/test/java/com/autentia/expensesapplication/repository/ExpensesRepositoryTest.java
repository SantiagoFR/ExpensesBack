package com.autentia.expensesapplication.repository;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.mapper.ExpenseRowMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ExpensesRepositoryTest {
    private ExpensesRepository expensesRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void init() {
        expensesRepository = new ExpensesRepository();
    }

    @Test
    public void expensesRepositoryShouldCallMapper() throws ParseException {

        List<Expense> expectedResponse = new ArrayList<Expense>(Arrays.asList(new Expense("Test", "Lorem Ipsum", "2000-01-01", 10.4f)));

        when(jdbcTemplate.query("SELECT * FROM expenses.expenses", new ExpenseRowMapper())).thenReturn(expectedResponse);

        List<Expense> expenses = expensesRepository.findAll();

        verify(jdbcTemplate).query("SELECT * FROM expenses.expenses", new ExpenseRowMapper());

        assertTrue(expenses.equals(expectedResponse));
    }

}
