package com.cc.engagetech.expenses.service;

import java.util.List;

import com.cc.engagetech.expenses.model.Expense;


public interface ExpenseService {

    Expense saveExpense(Expense expense);


    List<Expense> findAllExpenses();
}
