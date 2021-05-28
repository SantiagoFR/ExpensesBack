package com.autentia.expensesapplication.repository;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.mapper.ExpenseRowMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ExpensesRepositoryTest {
    private ExpensesRepository expensesRepository;

    @Before
    public void init() {
        expensesRepository = new ExpensesRepository();
    }

    @Test
    public void expensesRepositoryShouldCallMapper() {

        /*List<Expense> expectedResponse = new ArrayList<Expense>(Arrays.asList(new Expense("Test", "Lorem Ipsum", new Date(), 10.4f)));

        when(expenseRowMapper.findAll()).thenReturn(expectedResponse);

        List<Expense> expenses = expensesRepository.findAll();

        verify(expenseRowMapper).findAll();
        assertTrue(expenses.equals(expectedResponse));*/
    }

}
