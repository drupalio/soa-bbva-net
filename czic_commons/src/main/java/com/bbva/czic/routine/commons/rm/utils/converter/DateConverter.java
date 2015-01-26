package com.bbva.czic.routine.commons.rm.utils.converter;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Entelgy on 26/01/2015.
 */
public class DateConverter {

    final static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static Date convert(String strDate){
        try {
            return formatter.parse(strDate);
        } catch (ParseException e) {
            throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
        }
    }
}
