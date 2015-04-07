
package com.bbva.zic.products.business.dto;




public class DTOIntOperation {

    public final static long serialVersionUID = 1L;
    private String code;
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
