package com.bbva.czic.accounts.business.dto;

import java.util.Date;

/**
 * Created by Entelgy on 12/01/2015.
 */
public class DTOIntFilterAccount {

    private String accountId;
    private String month;
   private Date startMonth;
    private Date endMonth;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Date getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Date startMonth) {
        this.startMonth = startMonth;
    }

    public Date getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Date endMonth) {
        this.endMonth = endMonth;
    }
}
