
package com.bbva.czic.customers.business.dto;



import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import java.util.Date;

public class DTOIntAccMovementsResume {

    public final static long serialVersionUID = 1L;
    private Money income;
    private Money outcome;
    private Money balance;
    private Date month;

    public DTOIntAccMovementsResume() {
        //default constructor
    }

    public Money getIncome() {
        return income;
    }

    public void setIncome(Money income) {
        this.income = income;
    }

    public Money getOutcome() {
        return outcome;
    }

    public void setOutcome(Money outcome) {
        this.outcome = outcome;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

}
