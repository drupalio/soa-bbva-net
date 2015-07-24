package com.bbva.czic.loan.business.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;
import javax.validation.constraints.NotNull;

/**
 * Created by Entelgy on 28/01/2015.
 */
public class DTOIntFilterRotaryMovement {

    @Length(min = 16, max = 20)
    private String idLoan;

    @NotNull
    @Length(min = 6, max = 6)
    private String idMovement;

    @NotNull
    @Length(min = 4, max = 4)
    private String idExtracto;

    public DTOIntFilterRotaryMovement(){ }

    public DTOIntFilterRotaryMovement(String idLoan, String idMovement){
        this.idLoan = idLoan;
        this.idMovement = idMovement;
    }

    public String getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(String idLoan) {
        this.idLoan = idLoan;
    }

    public String getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(String idMovement) {
        this.idMovement = idMovement;
    }

    public String getIdExtracto() {
        return idExtracto;
    }

    public void setIdExtracto(String idExtracto) {
        this.idExtracto = idExtracto;
    }
}
