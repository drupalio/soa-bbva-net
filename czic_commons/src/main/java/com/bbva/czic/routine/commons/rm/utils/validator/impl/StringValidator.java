package com.bbva.czic.routine.commons.rm.utils.validator.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

/**
 * @author Entelgy
 */
public class StringValidator extends Validator {

	/**
	 * @param text
	 * @return
	 */
	public StringValidator isNumericText(String text) {
		if (!StringUtils.isNumeric(text)) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		return this;
	}

	/**
	 * @param strDate
	 * @return
	 */
	public StringValidator hasDateFormat(String strDate) {
		try {
			final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			formatter.parse(strDate);
		} catch (ParseException e) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		return this;
	}

	/**
	 * @param text
	 * @return
	 */
	public StringValidator notIsNull(String text) {
		if (StringUtils.isEmpty(text) || text.equals("null")) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		return this;
	}
	
	/**Valida que la string esté entre los valores 01 y 12 correspondientes a los meses
	 * 
	 * @param month
	 * @return
	 */
	public StringValidator isNumericMonth(String month) {
		if (StringUtils.isEmpty(month) || month.equals("null") || Integer.parseInt(month)<0 || Integer.parseInt(month)>12) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		return this;
	}
}
