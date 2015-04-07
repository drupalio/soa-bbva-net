package com.bbva.zic.cards.facade.v01;

import com.bbva.zic.cards.business.dto.DTOIntCardCharge;
import com.bbva.zic.cards.dao.model.ozno.FormatoOZECNOS0;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CardsChargesMapperTest {

	@Test()
	public void testMapToOuter() {
		DTOIntCardCharge dtoIntCardCharge = null;

		/*
		 * Objeto que vamos a mapear
		 */
		FormatoOZECNOS0 formatoSalida = new FormatoOZECNOS0();
		formatoSalida.setCategor("OCIO");
		formatoSalida.setValcate(new BigDecimal("100"));

		dtoIntCardCharge = CardsChargesMapper.mapToOuter(formatoSalida);

		assertEquals("OCIO",
				dtoIntCardCharge.getCategory());

		assertEquals(new BigDecimal("100"), dtoIntCardCharge.getAmount()
				.getAmount());

	}
}
