
package com.bbva.zic.globalposition.business.dto;




public class DTOIntOperation {

    public final static long serialVersionUID = 1L;
    private String operationCode;
    private String description;

    public DTOIntOperation() {
        //default constructor
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
