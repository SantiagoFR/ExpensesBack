package com.autentia.expensesapplication.web;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.entities.Friend;
import com.autentia.expensesapplication.service.ExpensesService;
import com.autentia.expensesapplication.service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
//TODO: Catch exceptions and return response informing frontend of the error
public class ExpensesController {
    private ExpensesService expensesService;

    private FriendsService friendsService;

    public ExpensesController(ExpensesService expensesService, FriendsService friendsService) {
        this.expensesService = expensesService;
        this.friendsService = friendsService;
    }

    @GetMapping(value = "/expenses")
    public List<Expense> findAll() {
        List<Expense> result = expensesService.findAll();
        Collections.sort(result);
        return result;
    }

    @PostMapping(value = "/expenses")
    public ResponseEntity<String> addExpense(
            @RequestBody Expense expense) {
        expensesService.addExpense(expense);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PutMapping(value = "/expenses/{id}")
    public ResponseEntity<String> updateExpense(
            @PathVariable("id") int id,
            @RequestBody Expense expense) {
        expensesService.updateExpense(id, expense);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping(value = "/expenses/{id}")
    public Expense getExpense(@PathVariable int id) { return expensesService.getExpense(id); }

    @GetMapping(value = "/expenses/balance")
    public Map<String, Float> getBalance() {
        List<Friend> friends = friendsService.findAll();
        Float totalDivided = expensesService.getExpensesInTotal() / friends.size();
        Map<String, Float> expensesByFriend = new HashMap<>();
        for (Friend friend : friends) {
            float expense = expensesService.getExpensesByAuthor(friend.getFullName()).floatValue() - totalDivided.floatValue();
            expensesByFriend.put(friend.getFullName(), Math.round(expense * 100f) / 100f);
        }

        return expensesByFriend;
    }



}
