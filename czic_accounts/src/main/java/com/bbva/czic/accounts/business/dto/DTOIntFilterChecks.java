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
    private Date startDate;
    private Date endDate;
    @NotNull
    private Integer paginationKey;
    @NotNull
    private Integer pageSize;
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
