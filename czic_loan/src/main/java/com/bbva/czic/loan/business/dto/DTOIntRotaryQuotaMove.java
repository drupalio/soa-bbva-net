package com.bbva.czic.loan.business.dto;

import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.Operation;


/**
 * Created by Entelgy on 17/01/2015.
 */
public class DTOIntRotaryQuotaMove extends Movement {

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
