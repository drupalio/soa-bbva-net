package com.bbva.czic.routine.commons.rm.utils.converter;

import java.util.Calendar;
import java.util.Date;

import com.bbva.czic.routine.mapper.CustomConverter;
import com.bbva.czic.routine.mapper.metadata.Type;

public class DateCalendarConverter extends CustomConverter<Date, Calendar> {

	@Override
	public Calendar convert(Date source, Type<? extends Calendar> destinationType) {

		final Calendar cal = Calendar.getInstance();
		cal.setTime(source);
		return cal;
	}

}
