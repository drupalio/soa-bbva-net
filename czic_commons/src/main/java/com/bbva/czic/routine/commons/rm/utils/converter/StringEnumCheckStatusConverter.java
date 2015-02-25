package com.bbva.czic.routine.commons.rm.utils.converter;

import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.czic.routine.mapper.CustomConverter;
import com.bbva.czic.routine.mapper.metadata.Type;

/**
 * @author Entelgy
 */
public class StringEnumCheckStatusConverter extends CustomConverter<String, String> {


	@Override
	public String convert(String source, Type<? extends String> destinationType) {
		return EnumCheckStatus.getByCode(source).name();
	}
}
