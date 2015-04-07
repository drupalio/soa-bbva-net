package com.bbva.zic.loan.dao.mappers.impl;

import com.bbva.zic.loan.business.dto.*;
import com.bbva.zic.loan.dao.model.ozni.FormatoOZNCENI0;
import com.bbva.zic.loan.dao.model.ozni.FormatoOZNCSNI0;
import com.bbva.zic.loan.dao.model.oznj.FormatoOZNCENJ0;
import com.bbva.zic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.zic.loan.dao.model.oznk.FormatoOZNCENK0;
import com.bbva.zic.loan.dao.model.oznk.FormatoOZNCSNK0;

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

    /**
     *
     * @param dtoIn
     * @return
     */
    FormatoOZNCENK0 mapInOznk(DTOIntFilterRotaryMovement dtoIn);

    /**
     *
     * @param formatOutput
     * @return
     */
    DTOIntRotaryQuotaMove mapOutOznk(FormatoOZNCSNK0 formatOutput);

    /**
     *
     * @param dtoIn
     * @return
     */
    FormatoOZNCENI0 mapInOzni(DTOIntFilterLoan dtoIn);

    /**
     *
     * @param formatOutput
     * @return
     */
    DTOIntMovement mapOutOzni(FormatoOZNCSNI0 formatOutput);



}
