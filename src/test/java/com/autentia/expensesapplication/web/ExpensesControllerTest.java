package com.autentia.expensesapplication.web;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.service.ExpensesService;
import com.sun.deploy.net.HttpResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
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
    public void expensesControllerShouldCallService() throws ParseException {
        List<Expense> expectedResponse = new ArrayList<Expense>(Arrays.asList(new Expense("Test", "Lorem Ipsum", "2000-01-01", 10.4f)));

        when(expensesService.findAll()).thenReturn(expectedResponse);

        List<Expense> expenses = expensesController.findAll();

        verify(expensesService).findAll();
        assertTrue(expenses.equals(expectedResponse));
    }

    @Test
    public void getExpenseByIdTest() throws ParseException {
        Expense expectedExpense = new Expense("Test", "Lorem Ipsum", "2000-01-01", 10.4f);
        expectedExpense.setId(1l);

        when(expensesService.getExpense(1)).thenReturn(expectedExpense);

        Expense expense = expensesController.getExpense(1);

        verify(expensesService).getExpense(1);

        assertEquals(1l, expense.getId());
    }


}
