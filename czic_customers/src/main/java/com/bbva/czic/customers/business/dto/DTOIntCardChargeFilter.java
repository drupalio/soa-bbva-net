package com.bbva.czic.customers.business.dto;

import com.bbva.czic.routine.commons.rm.utils.validator.IsCustomerId;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * @author Entelgy Colombia.
 */
public class DTOIntCardChargeFilter {

    @Pattern(regexp = "^\\d{8}$")
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
