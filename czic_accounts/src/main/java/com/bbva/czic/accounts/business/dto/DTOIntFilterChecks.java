package com.bbva.czic.accounts.business.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Entelgy on 17/01/2015.
 */
public class DTOIntFilterChecks {

    @NotNull
    private String accountId;
    @NotNull
    private String startDate;
    private String endDate;
    @NotNull
    private Integer paginationKey;
    @NotNull
    private Integer pageSize;
    @NotNull
    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public Integer getPaginationKey() {
        return paginationKey;
    }

    public void setPaginationKey(Integer paginationKey) {
        this.paginationKey = paginationKey;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
