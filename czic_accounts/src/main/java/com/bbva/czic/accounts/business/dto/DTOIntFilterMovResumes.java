package com.bbva.czic.accounts.business.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by Entelgy on 23/01/2015.
 */
public class DTOIntFilterMovResumes {

    @NotNull
    private String accountId;
    @NotNull
    @Length(max = 2)
    private String month;

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
}
