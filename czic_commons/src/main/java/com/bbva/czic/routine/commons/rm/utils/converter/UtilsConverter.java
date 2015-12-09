package com.bbva.czic.routine.commons.rm.utils.converter;

import java.math.BigDecimal;
import java.nio.Buffer;
import java.util.Currency;

import com.bbva.jee.arq.spring.core.servicing.utils.Money;

/**
 * Created by Entelgy on 11/01/2015.
 */
public class UtilsConverter {

	public static Money getMoneyDTO(BigDecimal amount) {
		Money money = new Money();
		money.setCurrency(Currency.getInstance("COP").getCurrencyCode());
		money.setAmount(amount);
		return money;
	}

	public static Money getMoneyDTO(String amount) {
		Money money = new Money();
		money.setCurrency(Currency.getInstance("COP").getCurrencyCode());
		money.setAmount(new BigDecimal(amount));
		return money;
	}
}
