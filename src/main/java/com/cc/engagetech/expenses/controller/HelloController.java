package com.cc.engagetech.expenses.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cc.engagetech.expenses.model.Expense;
import com.cc.engagetech.expenses.model.Role;
import com.cc.engagetech.expenses.model.User;
import com.cc.engagetech.expenses.repository.RoleRepository;
import com.cc.engagetech.expenses.repository.UserRepository;
import com.cc.engagetech.expenses.service.ExpenseService;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ExpenseService expenseService;

    @Autowired
    RoleRepository roleRepo;


    @GetMapping("say/{name}")
    public String sayHello(@PathVariable String name) {
        return String.format("Hello %s", name);
    }


    @PostMapping("user")
    public User saveUser(@RequestBody User user) {
        System.out.println("Will save user here: " + user);
        return userRepository.save(user);
    }


    @GetMapping("roles")
    public List<Role> getRoles() {
        return roleRepo.findAll();
    }


    @PostMapping("roles")
    public List<Role> saveRoles(@RequestBody ArrayList<Role> roles) {
        return roleRepo.save(roles);
    }


    @PostMapping("expense")
    public Expense saveExpense(@RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }
}
