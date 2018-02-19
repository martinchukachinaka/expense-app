package com.cc.engagetech.expenses.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "app_role")
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 1393589967518033752L;

    private String code;

    private String name;


    @Id
    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    @Override
    @Transient
    public String getAuthority() {
        return getName();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
