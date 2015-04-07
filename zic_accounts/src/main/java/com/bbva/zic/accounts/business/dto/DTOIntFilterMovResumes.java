package com.bbva.zic.accounts.business.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Entelgy on 23/01/2015.
 */
public class DTOIntFilterMovResumes {

    @NotNull
    @Length(max = 20, min = 20)
    private String accountId;

    @Length(max = 2)
    @Pattern(regexp = "^(0[1-9]|1[0-2])$")
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
