package com.bbva.czic.routine.commons.rm.utils.validator.impl;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.math.BigDecimal;

/**
 * Created by Entelgy on 19/01/2015.
 */
public class AmountValidator extends Validator{

    public AmountValidator() {
        super();
    }

    public AmountValidator validateRange(BigDecimal from, BigDecimal to){
        if(from != null && to != null && from.compareTo(to) == 1){
            throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
        }
        return this;
    }
}
