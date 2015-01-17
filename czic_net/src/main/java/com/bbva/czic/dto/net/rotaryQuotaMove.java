package com.bbva.czic.dto.net;

public class RotaryQuotaMove extends Movement{

    private String id;
    private Operation operation;


    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    

    public Operation getOperation() {
        return operation;
    }

    
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

}
