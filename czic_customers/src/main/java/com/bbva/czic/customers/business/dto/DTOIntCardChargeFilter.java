package com.bbva.czic.customers.business.dto;


/**
 * @author Entelgy Colombia.
 */
public class DTOIntCardChargeFilter {

    String startDate;
    String endDate;

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
                " startDate = " + startDate +
                ", endDate = " + endDate +
                "}";
    }
}
