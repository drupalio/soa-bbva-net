package com.bbva.czic.routine.commons.rm.utils.converter;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.bbva.czic.routine.mapper.CustomConverter;
import com.bbva.czic.routine.mapper.metadata.Type;

/**
 * Created by Entelgy on 27/01/2015.
 */
public class GregorianCalendarConverter extends CustomConverter<GregorianCalendar, Calendar> {

	@Override
	public Calendar convert(GregorianCalendar source, Type<? extends Calendar> destinationType) {

		final Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(source.getTime());
		return calendar;
	}
}
