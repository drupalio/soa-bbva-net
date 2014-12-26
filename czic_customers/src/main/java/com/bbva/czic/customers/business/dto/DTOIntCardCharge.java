
package com.bbva.czic.customers.business.dto;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;



public class DTOIntCardCharge {

    public final static long serialVersionUID = 1L;
    private DTOIntEnumCardChargeCategory category;
    private Money amount;

    public DTOIntCardCharge() {
        //default constructor
    }

    public DTOIntEnumCardChargeCategory getCategory() {
        return category;
    }

    public void setCategory(DTOIntEnumCardChargeCategory category) {
        this.category = category;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

}
