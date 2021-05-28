package com.autentia.expensesapplication.service;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.repository.ExpensesRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ExpensesServiceTest {
    private ExpensesService expensesService;

    private ExpensesRepository expensesRepository;

    @Before
    public void init() {
        expensesRepository = mock(ExpensesRepository.class);
        expensesService = new ExpensesService(expensesRepository);
    }

    @Test
    public void expensesServiceShouldCallRepository() {
        List<Expense> expectedResponse = new ArrayList<Expense>(Arrays.asList(new Expense("Test", "Lorem Ipsum", new Date(), 10.4f)));

        when(expensesRepository.findAll()).thenReturn(expectedResponse);

        List<Expense> expenses = expensesService.findAll();

        verify(expensesRepository).findAll();
        assertTrue(expenses.equals(expectedResponse));
    }
}
