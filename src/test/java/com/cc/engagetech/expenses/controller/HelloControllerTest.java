package com.cc.engagetech.expenses.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cc.engagetech.expenses.repository.UserRepository;
import com.cc.engagetech.expenses.service.ExpenseService;


@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    ExpenseService expenseService;

    @MockBean
    UserRepository userRepository;


    @Test
    public void itShouldSayHello() throws Exception {
        mvc.perform(get("/hello/say/chuka").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
