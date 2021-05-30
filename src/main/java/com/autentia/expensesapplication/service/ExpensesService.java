package com.autentia.expensesapplication.service;

import com.autentia.expensesapplication.entities.Expense;
import com.autentia.expensesapplication.repository.ExpensesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExpensesService {

    private ExpensesRepository expensesRepository;

    public ExpensesService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public List<Expense> findAll() {
        return expensesRepository.findAll();
    }

    public void addExpense(Expense expense) { expensesRepository.addExpense(expense); }

    public Expense getExpense(int id) { return expensesRepository.getExpense(id); }

    public void updateExpense(int id, Expense expense) { expensesRepository.updateExpense(id, expense); }

    public Map<String, Float> getBalance() { return expensesRepository.getBalance(); }
}
