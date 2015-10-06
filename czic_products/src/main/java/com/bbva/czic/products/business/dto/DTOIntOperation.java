
package com.bbva.czic.products.business.dto;


import javax.validation.constraints.NotNull;

public class DTOIntOperation {

    public final static long serialVersionUID = 1L;
    @NotNull
    private String code;
    @NotNull
    private String description;
    public DTOIntOperation() {
        //default constructor
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
