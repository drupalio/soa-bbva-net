package com.bbva.czic.loan.dao.mappers.impl;

import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCENI0;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCSNI0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;

/**
 * Created by Entelgy on 26/01/2015.
 */
public interface ITxMovementMapper {

    FormatoOZNCENI0 mapInOzni(DTOIntFilterLoan dtoIn);

    /**
     * @param formatOutput
     * @return
     */
    DTOIntMovement mapOutOzni(FormatoOZNCSNI0 formatOutput);
}
