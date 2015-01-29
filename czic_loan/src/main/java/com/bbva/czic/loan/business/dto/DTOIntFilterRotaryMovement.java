package com.bbva.czic.loan.business.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Entelgy on 28/01/2015.
 */
public class DTOIntFilterRotaryMovement {

    @NotNull
    @Length(min = 20, max = 20)
    private String idLoan;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Integer idMovement;

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
