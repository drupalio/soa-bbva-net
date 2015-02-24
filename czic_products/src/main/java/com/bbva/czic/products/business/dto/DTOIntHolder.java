package com.bbva.czic.products.business.dto;

import com.bbva.czic.dto.net.User;

import java.io.Serializable;

/**
 * Created by Entelgy on 24/02/2015.
 */
public class DTOIntHolder  extends User implements Serializable {

    private String alias;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
