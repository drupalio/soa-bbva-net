package com.bbva.zic.loan.business.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;
import javax.validation.constraints.NotNull;

/**
 * Created by Entelgy on 28/01/2015.
 */
public class DTOIntFilterRotaryMovement {

    @NotNull
    @Length(min = 20, max = 20)
    private String idLoan;

    @NotNull
    private Integer idMovement;

    @NotNull
    @Length(min = 4, max = 4)
    private String movementNumber;

    public DTOIntFilterRotaryMovement(){ }

    public DTOIntFilterRotaryMovement(String idLoan, Integer idMovement, String movementNumber){
        this.idLoan = idLoan;
        this.idMovement = idMovement;
        this.movementNumber = movementNumber;
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

    public String getMovementNumber() {
        return movementNumber;
    }

    public void setMovementNumber(String movementNumber) {
        this.movementNumber = movementNumber;
    }
}
