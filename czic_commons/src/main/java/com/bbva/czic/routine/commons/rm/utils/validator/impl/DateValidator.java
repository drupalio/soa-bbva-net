package com.bbva.czic.routine.commons.rm.utils.validator.impl;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.util.Date;

/**
 * Created by Entelgy on 12/01/2015.
 */
public class DateValidator extends Validator{

    private DateValidator() {
    }

    public DateValidator noFuture(Date date){
        if(date.after(new Date())){
            exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
        }
        return this;
    }

    
}
