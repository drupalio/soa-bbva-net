package com.bbva.zic.executives.business.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Entelgy on 10/01/2015.
 */
public class DTOIntExecutivesFilter {


    @NotNull
    @Size(min=1)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}