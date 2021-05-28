package com.autentia.expensesapplication.web;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpensesController {
    @Autowired
    private ExpensesService expensesService;

    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }
    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    public List<Expense> findAll() {
        return expensesService.findAll();
    }
}
