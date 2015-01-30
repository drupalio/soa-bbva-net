package com.bbva.czic.routine.commons.rm.utils.validator.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bbva.czic.routine.commons.rm.utils.EDateFormat;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

/**
 * Created by Entelgy on 12/01/2015.
 */
public class DateValidator extends Validator {

	final DateFormat formatter = new SimpleDateFormat(EDateFormat.ANIO_MES_DIA.getPattern());

	public DateValidator noFuture(Date date) {
		if (date.after(new Date())) {
			exceptions.add(new BusinessServiceException(EnumError.DATE_INTERVAL_OUT_OF_RANGE.getAlias()));
		}
		return this;
	}

	public DateValidator validDateRange(Date from, Date to) {
		if (from.after(to)) {
			exceptions.add(new BusinessServiceException(EnumError.DATE_INTERVAL_OUT_OF_RANGE.getAlias()));
		}
		return this;
	}

	public DateValidator hasDateFormat(String strDate){
		try {
			formatter.parse(strDate);
		} catch (ParseException e) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		return this;
	}

	public DateValidator validDateRange(String startDate, String endDate){
		try {
			if (formatter.parse(startDate).after(formatter.parse(endDate))) {
				exceptions.add(new BusinessServiceException(EnumError.DATE_INTERVAL_OUT_OF_RANGE.getAlias()));
			}
		} catch (ParseException e) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		return this;
	}
}
