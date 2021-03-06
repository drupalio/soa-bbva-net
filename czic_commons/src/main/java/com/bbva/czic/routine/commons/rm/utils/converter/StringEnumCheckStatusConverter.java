package com.bbva.czic.routine.commons.rm.utils.converter;

import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.czic.routine.mapper.CustomConverter;
import com.bbva.czic.routine.mapper.converter.BidirectionalConverter;
import com.bbva.czic.routine.mapper.metadata.Type;

/**
 * @author Entelgy
 */
public class StringEnumCheckStatusConverter extends BidirectionalConverter<String, String> {

	@Override
	public String convertTo(String source, Type<String> destinationType) {
		return EnumCheckStatus.getByCode(source).name();
	}

	@Override
	public String convertFrom(String source, Type<String> destinationType) {
		return EnumCheckStatus.getByCode(source).name();
	}

	@Override
	public boolean canConvert(Type<?> sourceType, Type<?> destinationType) {
		return true;
	}
}
