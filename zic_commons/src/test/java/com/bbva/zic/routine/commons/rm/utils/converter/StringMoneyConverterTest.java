package com.bbva.zic.routine.commons.rm.utils.converter;

import junit.framework.Assert;

import org.junit.Test;

import com.bbva.zic.routine.mapper.metadata.TypeFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class StringMoneyConverterTest {

	@Test
	public void checkStringMoneyConverterPositive() {

		final String balancePositive = "+12365498";
		final Money result = new StringMoneyConverter().convert(balancePositive, TypeFactory.typeOf(new Money()));
		Assert.assertEquals(result.getCurrency(), "COP");
		Assert.assertEquals(result.getAmount().toString(), "123654.98");
	}

	@Test
	public void checkStringMoneyConverterNegative() {

		final String balancePositive = "-12365457";
		final Money result = new StringMoneyConverter().convert(balancePositive, TypeFactory.typeOf(new Money()));
		Assert.assertEquals(result.getCurrency(), "COP");
		Assert.assertEquals(result.getAmount().toString(), "-123654.57");
	}

	@Test
	public void checkStringMoneyWithoutSigned() {

		final String balancePositive = "12365457";
		final Money result = new StringMoneyConverter().convert(balancePositive, TypeFactory.typeOf(new Money()));
		Assert.assertEquals(result.getCurrency(), "COP");
		Assert.assertEquals(result.getAmount().toString(), "123654.57");
	}

}
