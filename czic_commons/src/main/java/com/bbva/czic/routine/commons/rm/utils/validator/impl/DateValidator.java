package com.bbva.czic.routine.commons.rm.utils.validator.impl;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;

/**
 * Created by Entelgy on 12/01/2015.
 */
public class DateValidator extends Validator{

    public DateValidator() {
        super();
    }

    public DateValidator noFuture(Date date){
        if(date.after(new Date())){
            exceptions.add(new BusinessServiceException(EnumError.DATE_INTERVAL_OUT_OF_RANGE.getAlias()));
        }
        return this;
    }

    public DateValidator validDateRange(Date from, Date to){
        if(from.after(to)){
            exceptions.add(new BusinessServiceException(EnumError.DATE_INTERVAL_OUT_OF_RANGE.getAlias()));
        }
        return this;
    }
}
