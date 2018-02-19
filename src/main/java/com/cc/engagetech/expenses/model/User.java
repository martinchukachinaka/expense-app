package com.cc.engagetech.expenses.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class User extends BaseModel implements UserDetails {

    private static final long serialVersionUID = 5868279680667242505L;

    private boolean enabled = true;

    private String password;

    @Size(min = 3)
    private String username;

    private Set<Role> roles = new HashSet<>();

    private Set<Expense> expenses = new HashSet<>();


    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    @Override
    public boolean isEnabled() {
        return this.enabled;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Role> getRoles() {
        return roles;
    }


    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }


    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return isEnabled();
    }


    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return isEnabled();
    }


    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return isEnabled();
    }


    @Override
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    @OneToMany(mappedBy = "owner")
    public Set<Expense> getExpenses() {
        return expenses;
    }


    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }
}
