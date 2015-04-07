package com.bbva.zic.accounts.business.dto;

import java.io.Serializable;

/**
 * Created by Entelgy on 23/01/2015.
 * DTO para poder filtrar en el SMC de listCheck
 */
public class DTOIntListCheck implements Serializable{

    public final static long serialVersionUID = 1L;
    private DTOIntCheck check;

    public DTOIntCheck getCheck() {
        return check;
    }

    public void setCheck(DTOIntCheck check) {
        this.check = check;
    }
}
