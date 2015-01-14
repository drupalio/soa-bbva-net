
package com.bbva.czic.products.business.dto;




public class DTOIntActivity {

    public final static long serialVersionUID = 1L;
    private String operationDate;
    private String executionDate;
    private DTOIntFunction function;
    private String amount;
    private String reference;

    public DTOIntActivity() {
        //default constructor
    }

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    public DTOIntFunction getFunction() {
        return function;
    }

    public void setFunction(DTOIntFunction function) {
        this.function = function;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
