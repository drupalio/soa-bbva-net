package com.bbva.czic.routine.mapper.factory;

import com.bbva.czic.routine.mapper.MappingContext;
import com.bbva.czic.routine.mapper.ObjectFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class MoneyFactory implements ObjectFactory<Money> {

	/**
	 * 
	 */
	@Override
	public Money create(Object source, MappingContext mappingContext) {

		final Money sourceMoney = (Money)source;
		final Money money = new Money();
		money.setAmount(sourceMoney.getAmount());
		money.setCurrency(sourceMoney.getCurrency());

		return money;
	}

}
