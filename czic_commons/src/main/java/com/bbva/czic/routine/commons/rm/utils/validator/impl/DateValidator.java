package com.bbva.czic.routine.commons.rm.utils.validator.impl;

import java.util.Date;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

/**
 * Created by Entelgy on 12/01/2015.
 */
public class DateValidator extends Validator {

	public DateValidator() {
		super();
	}

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

}
