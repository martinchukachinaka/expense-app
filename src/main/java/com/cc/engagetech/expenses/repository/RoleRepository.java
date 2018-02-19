package com.cc.engagetech.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cc.engagetech.expenses.model.Role;


public interface RoleRepository extends JpaRepository<Role, String> {
}
