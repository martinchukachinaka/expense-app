package com.cc.engagetech.expenses;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cc.engagetech.expenses.model.Expense;
import com.cc.engagetech.expenses.repository.ExpenseRepository;
import com.cc.engagetech.expenses.service.ExpenseService;
import com.cc.engagetech.expenses.service.impl.ExpenseServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ExpenseServiceImplTest {

    @TestConfiguration
    static class ExpenseServiceImplTestContextConfiguration {

        @Bean
        public ExpenseService expenseService() {
            return new ExpenseServiceImpl();
        }
    }


    @Autowired
    private ExpenseService expenseService;

    @MockBean
    private ExpenseRepository expenseRepo;


    @Before
    public void provideMockedBehaviour() {
        Mockito.when(expenseRepo.save(BDDMockito.any(Expense.class))).thenReturn(createNewExpense(1L));
    }


    @Test
    public void itShouldSaveAnExpense() {
        Expense expense = createNewExpense();
        assertThat(expense).isNotNull();
        expense = expenseService.saveExpense(expense);
        assertThat(expense.getId()).isEqualTo(1L);
    }


    private Expense createNewExpense() {
        Expense expense = new Expense();
        expense.setName("Test Expense");
        expense.setReason("Testing the mike");
        expense.setAmountEntered(new BigDecimal("1000"));
        return expense;
    }


    private Expense createNewExpense(Long id) {
        Expense expense = createNewExpense();
        expense.setId(id);
        return expense;
    }
}
