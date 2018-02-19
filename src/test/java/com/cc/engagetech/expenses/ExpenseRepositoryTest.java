package com.cc.engagetech.expenses;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cc.engagetech.expenses.model.Expense;
import com.cc.engagetech.expenses.repository.ExpenseRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ExpenseRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    Expense expense;

    @Autowired
    ExpenseRepository expenseRepo;


    @Before
    public void setUp() {
        expense = entityManager.persist(createNewExpense());
    }


    private Expense createNewExpense() {
        Expense expense = new Expense();
        expense.setName("Test Expense");
        expense.setReason("Testing the mike");
        return expense;
    }


    @Test
    public void itShouldAtLeastOneExpense() {
        List<Expense> data = expenseRepo.findAll();
        assertThat(data).isNotEmpty();
    }


    @Test
    public void itShouldSaveAnExpense() {
        assertThat(expenseRepo.save(createNewExpense())).isNotNull();
    }
}
