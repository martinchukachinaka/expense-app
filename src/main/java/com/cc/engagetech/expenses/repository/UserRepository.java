package com.cc.engagetech.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cc.engagetech.expenses.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
