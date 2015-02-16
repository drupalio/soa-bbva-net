package com.bbva.czic.routine.commons.rm.utils.converter;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.bbva.czic.routine.commons.rm.utils.CurrencyEnum;
import com.bbva.czic.routine.mapper.CustomConverter;
import com.bbva.czic.routine.mapper.metadata.Type;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

/**
 * @author Entelgy
 */
public class StringMoneyConverter extends CustomConverter<String, Money> {

	private static int DECIMAL_SIZE = 2;

	/**
	 * 
	 */
	@Override
	public Money convert(String source, Type<? extends Money> destinationType) {

		final Money result = new Money();
		result.setCurrency(CurrencyEnum.COP.name());

		final String entera = StringUtils.left(source.trim(), source.trim().length() - DECIMAL_SIZE);
		final String decimal = StringUtils.right(source.trim(), DECIMAL_SIZE);
		final BigDecimal amount = new BigDecimal(entera + "." + decimal);
		result.setAmount(amount);

		return result;
	}
}
