package com.bbva.czic.accounts.business.dto;

import com.bbva.czic.dto.net.EnumCheckStatus;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Entelgy on 17/01/2015.
 */
public class DTOIntFilterCheckbooks {

    public final static long serialVersionUID = 1L;
    @NotNull
    @Length(min = 20, max = 20)
    private String id;

    @NotNull
    @Length(min = 20, max = 20)
    private String idAccount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }
}
