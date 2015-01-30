
package com.bbva.czic.customers.business.dto;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class DTOIntCardCharge {

    public final static long serialVersionUID = 1L;
    @NotEmpty
    private String category;
    @NotNull
    private Money amount;

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

    @Override
    public String toString() {
        return "DTOIntCardCharge{" +
                "category=" + category +
                ", amount=" + amount +
                '}';
    }
}
