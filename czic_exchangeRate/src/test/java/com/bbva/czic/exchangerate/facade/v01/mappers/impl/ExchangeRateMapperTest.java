package com.bbva.czic.exchangerate.facade.v01.mappers.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.dto.net.ExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateAssessments;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateFilter;
import com.bbva.czic.exchangerate.facade.v01.mapper.impl.ExchangeRateMapperImpl;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;

/**
 * Created by Entelgy on 13/01/2015.
 */
public class ExchangeRateMapperTest extends SpringContextBbvaTest {

	ExchangeRateMapperImpl exchangeRateMapper;

	@Before
	public void init() {
		exchangeRateMapper = new ExchangeRateMapperImpl();
	}

	@Test
	public void testExchangeRateMapper() {
		final DTOIntExchangeRate dtoExchangeRate = new DTOIntExchangeRate();

		final List<DTOIntExchangeRateAssessments> listAssements = new ArrayList<DTOIntExchangeRateAssessments>();
		DTOIntExchangeRateAssessments assements = new DTOIntExchangeRateAssessments();
		assements.setType("TasaDivisaUSD");
		assements.setValue(new BigDecimal(123));
		listAssements.add(assements);

		assements = new DTOIntExchangeRateAssessments();
		assements.setType("TasaUSDMoneda");
		assements.setValue(new BigDecimal(1234));
		listAssements.add(assements);

		assements = new DTOIntExchangeRateAssessments();
		assements.setType("TasaDivisaMoneda");
		assements.setValue(new BigDecimal(12345));
		listAssements.add(assements);

		assements = new DTOIntExchangeRateAssessments();
		assements.setType("TotalPesos");
		assements.setValue(new BigDecimal(12345));
		listAssements.add(assements);
		dtoExchangeRate.setExchangeRateAssessments(listAssements);

		ExchangeRate exchangeRate = exchangeRateMapper.map(dtoExchangeRate);
		Assert.assertNotNull(exchangeRate);

	}

	@Test
	public void testExchangeRateFilter() {
		DTOIntExchangeRateFilter exchangeRateFilter = exchangeRateMapper.map("USD", "1026183049",
				new BigDecimal(100000), null);
		Assert.assertNotNull(exchangeRateFilter);
	}
}
