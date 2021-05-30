package com.autentia.expensesapplication.web;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.service.ExpensesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
//TODO: Catch exceptions and return response informing frontend of the error
public class ExpensesController {
    private ExpensesService expensesService;

    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
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

    @GetMapping(value = "expenses/balance")
    public Map<String, Float> getBalance() { return expensesService.getBalance(); }

}
