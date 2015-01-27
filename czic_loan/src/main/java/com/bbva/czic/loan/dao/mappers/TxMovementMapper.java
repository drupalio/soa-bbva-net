package com.bbva.czic.loan.dao.mappers;

import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.dao.mappers.impl.ITxMovementMapper;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCENI0;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCSNI0;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Entelgy on 26/01/2015.
 */
@Component(value = "tx-movement-mapper")
public class TxMovementMapper extends ConfigurableMapper implements ITxMovementMapper {


    @Override
    public FormatoOZNCENI0 mapInOzni(DTOIntFilterLoan dtoIn) {
        return map(dtoIn, FormatoOZNCENI0.class);
    }

    @Override
    public DTOIntMovement mapOutOzni(FormatoOZNCSNI0 formatOutput) {
        return map(formatOutput, DTOIntMovement.class);
    }
}
