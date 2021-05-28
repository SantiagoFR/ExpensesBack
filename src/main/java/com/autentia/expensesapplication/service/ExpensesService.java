package com.autentia.expensesapplication.service;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepository;

    public ExpensesService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public List<Expense> findAll() {
        return expensesRepository.findAll();
    }
}
