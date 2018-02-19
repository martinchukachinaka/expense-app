package com.cc.engagetech.expenses.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.engagetech.expenses.model.Expense;
import com.cc.engagetech.expenses.repository.ExpenseRepository;
import com.cc.engagetech.expenses.service.ExpenseService;


@Service
public class ExpenseServiceImpl implements ExpenseService {

    Logger LOG = LoggerFactory.getLogger(ExpenseServiceImpl.class);

    @Autowired
    private ExpenseRepository expenseRepo;


    @Override
    public Expense saveExpense(Expense expense) {
        // expense.getAmountEntered().setScale(2, BigDecimal.ROUND_HALF_EVEN);
        // BigDecimal valueAmountScaler = new BigDecimal(100.00).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        // BigDecimal enteredAmountScaler = new BigDecimal(120.00).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        // expense.setValueAmount(expense.getAmountEntered().multiply(valueAmountScaler).divide(enteredAmountScaler,
        // BigDecimal.ROUND_HALF_EVEN));
        // expense.setValueAddedTax(expense.getAmountEntered().subtract(expense.getValueAmount()));
        return expenseRepo.save(expense);
    }


    @Override
    public List<Expense> findAllExpenses() {
        return expenseRepo.findAll();
    }
}
