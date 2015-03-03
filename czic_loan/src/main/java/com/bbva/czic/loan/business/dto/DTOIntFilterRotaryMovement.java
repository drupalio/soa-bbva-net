package com.bbva.czic.loan.business.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;
import javax.validation.constraints.NotNull;

/**
 * Created by Entelgy on 28/01/2015.
 */
public class DTOIntFilterRotaryMovement {

    @Length(min = 20, max = 20)
    private String idLoan;

    @NotNull
    private Integer idMovement;

    public DTOIntFilterRotaryMovement(){ }

    public DTOIntFilterRotaryMovement(String idLoan, Integer idMovement){
        this.idLoan = idLoan;
        this.idMovement = idMovement;
    }

    public String getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(String idLoan) {
        this.idLoan = idLoan;
    }

    public Integer getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(Integer idMovement) {
        this.idMovement = idMovement;
    }
}
