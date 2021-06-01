package com.autentia.expensesapplication.repository;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.mapper.ExpenseRowMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ExpensesRepositoryTest {
    private ExpensesRepository expensesRepository;

    private JdbcTemplate jdbcTemplate;

    @Before
    public void init() {
        jdbcTemplate = mock(JdbcTemplate.class);
        expensesRepository = new ExpensesRepository(jdbcTemplate);
    }

    @Test
    public void expensesRepositoryShouldCallJDBC() throws ParseException {
        Expense expectedExpense = new Expense();
        expectedExpense.setId(1);
        when(jdbcTemplate.query(anyString(),  any(ExpenseRowMapper.class))).thenReturn(new ArrayList<Expense>());
        when(jdbcTemplate.update(anyString(), anyString())).thenReturn(1);
        when(jdbcTemplate.queryForObject(anyString(), anyObject(), any(ExpenseRowMapper.class))).thenReturn(expectedExpense);
        when(jdbcTemplate.queryForObject(anyString(), anyObject(), eq(Float.class))).thenReturn(3f);
        when(jdbcTemplate.queryForObject(anyString(), eq(Float.class) )).thenReturn(4f);

        List<Expense> expenses = expensesRepository.findAll();
        expensesRepository.addExpense(new Expense());
        expensesRepository.updateExpense(1, new Expense());
        Expense expense = expensesRepository.getExpense(1);
        Float float1 = expensesRepository.getExpensesByAuthor("");
        Float float2 = expensesRepository.getExpensesInTotal();

        assertTrue(expenses.equals(new ArrayList<Expense>()));
        assertEquals(expense, expectedExpense);
        assertTrue(float1.equals(3f));
        assertTrue(float2.equals(4f));

        verify(jdbcTemplate, times(1)).query(anyString(), any(ExpenseRowMapper.class));
        verify(jdbcTemplate, times(1)).update(anyString(), anyString(), anyFloat(), anyString(), anyString());
        verify(jdbcTemplate, times(1)).update(anyString(), anyString(), anyFloat(), anyString(), anyString(), anyInt());
        verify(jdbcTemplate, times(1)).queryForObject(anyString(), anyObject(), any(ExpenseRowMapper.class));

        when(jdbcTemplate.queryForObject(anyString(), anyObject(), eq(Float.class))).thenReturn(null);
        when(jdbcTemplate.queryForObject(anyString(), eq(Float.class) )).thenReturn(null);
        float1 = expensesRepository.getExpensesByAuthor("");
        float2 = expensesRepository.getExpensesInTotal();

        assertTrue(float1.equals(0f));
        assertTrue(float2.equals(0f));
    }

}
