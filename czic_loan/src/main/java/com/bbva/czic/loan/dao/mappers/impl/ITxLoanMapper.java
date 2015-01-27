package com.bbva.czic.loan.dao.mappers.impl;

import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;

/**
 * Created by Entelgy on 26/01/2015.
 */
public interface ITxLoanMapper {

    /**
     * @param dtoIn
     * @return
     */
    FormatoOZNCENJ0 mapInOznj(DTOIntFilterLoan dtoIn);

    /**
     * @param formatOutput
     * @return
     */
    DTOIntLoan mapOutOznj(FormatoOZNCSNJ0 formatOutput);

}
