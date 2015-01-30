package com.bbva.czic.customers.business.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Entelgy Colombia.
 */
public class DTOIntCardChargeFilter {
    @NotEmpty
    String customerId;
    String startDate;
    String endDate;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "DTOIntCardChargeFilter{" +
                "customerId = " + customerId +
                ", startDate = " + startDate +
                ", endDate = " + endDate +
                "}";
    }
}
