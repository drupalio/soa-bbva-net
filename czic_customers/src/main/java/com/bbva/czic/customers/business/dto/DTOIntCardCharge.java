
package com.bbva.czic.customers.business.dto;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import java.util.Date;


public class DTOIntCardCharge {

    public final static long serialVersionUID = 1L;
    private String category;
    private Money amount;
    private Date chargeDate;

    public DTOIntCardCharge() {
        //default constructor
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public Date getChargeDate() {
        return chargeDategit;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }

    @Override
    public String toString() {
        return "DTOIntCardCharge{" +
                "category=" + category +
                ", amount=" + amount +
                ", chargeDate=" + chargeDate +
                '}';
    }
}
