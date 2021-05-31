package com.autentia.expensesapplication.web;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.entities.Friend;
import com.autentia.expensesapplication.service.ExpensesService;
import com.autentia.expensesapplication.service.FriendsService;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ExpensesControllerTest {
    private ExpensesController expensesController;
    private ExpensesService expensesService;
    private FriendsService friendsService;
    private List<Expense> expenses;
    @Before
    public void init() throws ParseException {
        expenses = new ArrayList<>(Arrays.asList(
                new Expense("Francisco Buyo", "Cena", "2000-01-01", 100f),
                new Expense("Alfonso Pérez", "Taxi", "2000-01-01", 10f),
                new Expense("Alfonso Pérez", "Compra", "2000-01-01", 53.4f)
        ));

        expensesService = mock(ExpensesService.class);
        when(expensesService.findAll()).thenReturn(this.expenses);
        friendsService = mock(FriendsService.class);
        expensesController = new ExpensesController(expensesService, friendsService);
    }

    @Test
    public void expensesControllerShouldCallService() {
        List<Expense> expenses = expensesController.findAll();

        verify(expensesService).findAll();

        assertTrue(expenses.equals(this.expenses));
    }

    @Test
    public void getExpenseByIdTest() throws ParseException {
        Expense expectedExpense = new Expense("Test", "Lorem Ipsum", "2000-01-01", 10.4f);
        expectedExpense.setId(9l);

        when(expensesService.getExpense(9)).thenReturn(expectedExpense);

        Expense expense = expensesController.getExpense(9);

        verify(expensesService).getExpense(9);

        assertEquals(9l, expense.getId());
    }

    @Test
    public void getBalanceTest() {
        List<Friend> friends = new ArrayList<>(Arrays.asList(
                new Friend("Francisco", "Buyo"),
                new Friend("Alfonso", "Pérez"),
                new Friend("Raúl", "González"),
                new Friend("José María", "Gutiérrez")
        ));
        Map<String, Float> expectedBalance = new HashMap<>();
        expectedBalance.put("Francisco Buyo", 59.15f);
        expectedBalance.put("Alfonso Pérez", 22.55f);
        expectedBalance.put("Raúl González", -40.85f);
        expectedBalance.put("José María Gutiérrez", -40.85f);

        when(friendsService.findAll()).thenReturn(friends);
        when(expensesService.getExpensesInTotal()).thenReturn(163.4f);
        when(expensesService.getExpensesByAuthor("Francisco Buyo")).thenReturn(100f);
        when(expensesService.getExpensesByAuthor("Alfonso Pérez")).thenReturn(63.4f);
        when(expensesService.getExpensesByAuthor("Raúl González")).thenReturn(0f);
        when(expensesService.getExpensesByAuthor("José María Gutiérrez")).thenReturn(0f);

        Map<String, Float> balance = expensesController.getBalance();

        verify(friendsService).findAll();

        assertEquals(balance, expectedBalance);
    }


}
