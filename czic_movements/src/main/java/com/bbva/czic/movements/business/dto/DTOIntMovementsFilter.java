package com.bbva.czic.movements.business.dto;

import com.bbva.czic.dto.net.EnumProductType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Entelgy on 17/01/2015.
 */
public class DTOIntMovementsFilter implements Serializable {
    public final static long serialVersionUID = 1L;
    private EnumProductType productType;
    private String productId;
    private Date startDate;
    private Date endDate;
    private BigDecimal bottomValue;
    private BigDecimal topValue;

    public DTOIntMovementsFilter() {
    }

    public EnumProductType getProductType() {
        return productType;
    }

    public void setProductType(EnumProductType productType) {
        this.productType = productType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getBottomValue() {
        return bottomValue;
    }

    public void setBottomValue(BigDecimal bottomValue) {
        this.bottomValue= bottomValue;
    }

    public BigDecimal getTopValue() {
        return topValue;
    }

    public void setTopValue(BigDecimal topValue) {
        this.topValue= topValue;
    }

    @Override
    public String toString() {
        return "DTOIntMovementsFilter{" +
                "productType=" + productType +
                ", productId='" + productId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", bottomValue=" + bottomValue +
                ", topValue=" + topValue +
                '}';
    }
}
