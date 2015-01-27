package com.bbva.czic.loan.dao.mappers.impl;

import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;

import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMovement;

import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCENK0;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCSNK0;

/**
 * Created by Entelgy on 27/01/2015.
 */
public interface ITxRotaryQuotaMovementMapper {

    FormatoOZNCENK0 mapInOzni(DTOIntFilterLoan dtoIn);

    /**
     * @param formatOutput
     * @return
     */
    DTOIntRotaryQuotaMove mapOutOzni(FormatoOZNCSNK0 formatOutput);
}
