package com.bbva.czic.cards.facade.v01;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOS0;
import com.bbva.czic.dto.net.EnumCardChargeCategory;

public class CardsChargesMapperTest {

	@Test()
	public void testMapToOuter() {
		DTOIntCardCharge dtoIntCardCharge = null;

		/*
		 * Objeto que vamos a mapear
		 */
		FormatoOZECNOS0 formatoSalida = new FormatoOZECNOS0();
		formatoSalida.setCategor(EnumCardChargeCategory.BASIC_COMMERCE
				.toString());
		formatoSalida.setValcate(new BigDecimal("100"));

		dtoIntCardCharge = CardsChargesMapper.mapToOuter(formatoSalida);

		assertEquals(EnumCardChargeCategory.BASIC_COMMERCE.toString(),
				dtoIntCardCharge.getCategory().toString());

		assertEquals(new BigDecimal("100"), dtoIntCardCharge.getAmount()
				.getAmount());

	}
}
