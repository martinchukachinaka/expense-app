package com.cc.engagetech.expenses.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Expense extends BaseModel {

    private static final long serialVersionUID = -4479223708876668711L;

    private BigDecimal amountEntered = new BigDecimal(0);

    private BigDecimal valueAmount = new BigDecimal(0);

    private BigDecimal valueAddedTax = new BigDecimal(0);

    private String reason;

    private Date expenseDate = new Date();

    private User owner;


    @Lob
    public String getReason() {
        return reason;
    }


    public void setReason(String reason) {
        this.reason = reason;
    }


    @ManyToOne
    public User getOwner() {
        return owner;
    }


    public void setOwner(User owner) {
        this.owner = owner;
    }


    public BigDecimal getValueAddedTax() {
        return valueAddedTax;
    }


    public void setValueAddedTax(BigDecimal valueAddedTax) {
        this.valueAddedTax = valueAddedTax;
    }


    public BigDecimal getValueAmount() {
        return valueAmount;
    }


    public void setValueAmount(BigDecimal valueAmount) {
        this.valueAmount = valueAmount;
    }


    public BigDecimal getAmountEntered() {
        return amountEntered;
    }


    public void setAmountEntered(BigDecimal amountEntered) {
        this.amountEntered = amountEntered;
    }


    @Temporal(TemporalType.TIMESTAMP)
    public Date getExpenseDate() {
        return expenseDate;
    }


    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }
}
