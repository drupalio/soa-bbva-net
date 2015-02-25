package com.bbva.czic.routine.commons.rm.utils.converter;

import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.czic.routine.commons.rm.utils.CurrencyEnum;
import com.bbva.czic.routine.mapper.CustomConverter;
import com.bbva.czic.routine.mapper.metadata.Type;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.apache.commons.lang.StringUtils;

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
