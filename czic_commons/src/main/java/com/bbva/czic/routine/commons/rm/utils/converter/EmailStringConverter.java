package com.bbva.czic.routine.commons.rm.utils.converter;

import com.bbva.czic.dto.net.Email;
import com.bbva.czic.routine.mapper.CustomConverter;
import com.bbva.czic.routine.mapper.metadata.Type;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Entelgy
 */
public class EmailStringConverter extends CustomConverter<Email, String> {
	@Override
	public String convert(Email source, Type<? extends String> destinationType) {
		return source.getAddress();
	}
}
