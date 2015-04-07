package com.bbva.zic.cards.business;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.bbva.zic.cards.business.dto.DTOIntCardCharge;
import com.bbva.zic.dto.net.CardCharge;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class CardsMapperTest {

	@Test()
	public void mapOuter() {
		CardCharge cardCharge = null;

		DTOIntCardCharge dtoIntCardCharge = new DTOIntCardCharge();
		Money money = new Money();
		money.setAmount(new BigDecimal("100"));
		dtoIntCardCharge.setAmount(money);
		dtoIntCardCharge.setCategory("OCIO");
		cardCharge = CardsMapper.mapOuter(dtoIntCardCharge);

		assertEquals(dtoIntCardCharge.getAmount().getAmount(), new BigDecimal(
				"100"));
		assertEquals(dtoIntCardCharge.getCategory().toString(),"OCIO");

	}
}
