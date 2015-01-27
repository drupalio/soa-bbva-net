package com.bbva.czic.routine.commons.rm.utils.converter;

import java.util.Calendar;
import java.util.Date;

import com.bbva.czic.routine.mapper.CustomConverter;
import com.bbva.czic.routine.mapper.metadata.Type;

/**
 * @author Entelgy
 */
public class CalendarDateConverter extends CustomConverter<Calendar, Date> {

	/**
	 * 
	 */
	@Override
	public Date convert(Calendar source, Type<? extends Date> destinationType) {
		return source.getTime();
	}
	
	



}
