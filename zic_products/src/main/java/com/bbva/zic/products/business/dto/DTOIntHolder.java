package com.bbva.zic.products.business.dto;

import java.io.Serializable;

/**
 * Created by Entelgy on 24/02/2015.
 */
public class DTOIntHolder  extends DTOIntUser implements Serializable {

    private String alias;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
