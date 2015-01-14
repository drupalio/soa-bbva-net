
package com.bbva.czic.products.business.dto;




public class DTOIntFunction {

    public final static long serialVersionUID = 1L;
    private String id;
    private DTOIntEnumFunctionType type;

    public DTOIntFunction() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DTOIntEnumFunctionType getType() {
        return type;
    }

    public void setType(DTOIntEnumFunctionType type) {
        this.type = type;
    }

}
