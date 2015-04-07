package com.bbva.zic.routine.commons.rm.utils.converter;


import com.bbva.zic.dto.net.EnumCheckStatus;
import com.bbva.zic.routine.mapper.CustomConverter;
import com.bbva.zic.routine.mapper.metadata.Type;

import java.math.BigDecimal;

/**
 * @author Entelgy
 */
public class EnumCheckStatusConverter extends CustomConverter<EnumCheckStatus, String> {

	@Override
	public String convert(EnumCheckStatus source, Type<? extends String> destinationType) {
		return source.getCodigo();
	}
}
