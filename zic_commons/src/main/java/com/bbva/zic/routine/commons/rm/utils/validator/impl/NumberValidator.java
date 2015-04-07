package com.bbva.zic.routine.commons.rm.utils.validator.impl;

import com.bbva.zic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public class NumberValidator extends Validator {

	/**
	 * @param text
	 * @return
	 */
	public NumberValidator notIsNull(Number number) {
		if (number == null) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		return this;
	}

	/**
	 * @param text
	 * @return
	 */
	public NumberValidator notIsZero(Number number) {
		if (number == null || number.equals(0)) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		return this;
	}

}
