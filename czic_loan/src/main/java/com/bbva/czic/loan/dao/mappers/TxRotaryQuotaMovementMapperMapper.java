package com.bbva.czic.loan.dao.mappers;

import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMovement;
import com.bbva.czic.loan.dao.mappers.impl.ITxRotaryQuotaMovementMapper;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCENK0;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCSNK0;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;

/**
 * Created by Entelgy on 27/01/2015.
 */
public class TxRotaryQuotaMovementMapperMapper extends ConfigurableMapper implements ITxRotaryQuotaMovementMapper {
    @Override
    public FormatoOZNCENK0 mapInOzni(DTOIntFilterLoan dtoIn) {

            return map(dtoIn, FormatoOZNCENK0.class);

    }

    @Override
    public DTOIntRotaryQuotaMove mapOutOzni(FormatoOZNCSNK0 formatOutput) {
        return map(formatOutput, DTOIntRotaryQuotaMove.class);
    }
}
