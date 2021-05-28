package com.autentia.expensesapplication.web;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.service.ExpensesService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ExpensesControllerTest {
    private ExpensesController expensesController;

    private ExpensesService expensesService;

    @Before
    public void init(){
        expensesService = mock(ExpensesService.class);
        expensesController = new ExpensesController(expensesService);
    }

    @Test
    public void expensesControllerShouldCallService() {
        List<Expense> expectedResponse = new ArrayList<Expense>(Arrays.asList(new Expense("Test", "Lorem Ipsum", new Date(), 10.4f)));

        when(expensesService.findAll()).thenReturn(expectedResponse);

        List<Expense> expenses = expensesController.findAll();

        verify(expensesService).findAll();
        assertTrue(expenses.equals(expectedResponse));
    }

}
