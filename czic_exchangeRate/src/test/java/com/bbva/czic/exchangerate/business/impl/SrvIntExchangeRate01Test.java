package com.bbva.czic.exchangerate.business.impl;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateAssessments;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateFilter;
import com.bbva.czic.exchangerate.dao.ExchangeRateDAO;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

@ActiveProfiles("dev")
public class SrvIntExchangeRate01Test extends SpringContextBbvaTest {

	@Mock
	private ExchangeRateDAO exchangeRateDAO;

	@InjectMocks
	SrvIntExchangeRate srv;

	@Before
	public void init() {
		srv = new SrvIntExchangeRate();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetExchangeRatePurchase() {
		final DTOIntExchangeRateFilter exchangeRateFilter = new DTOIntExchangeRateFilter();
		exchangeRateFilter.setCurrencyId("USD");
		exchangeRateFilter.setCustomerId("1026283049");
		exchangeRateFilter.setPurchaseAmount(new BigDecimal(100000));
		exchangeRateFilter.setSaleAmount(null);

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

		Mockito.when(exchangeRateDAO.getExchangeRate(exchangeRateFilter)).thenReturn(dtoExchangeRate);
		final DTOIntExchangeRate respuesta = srv.getExchangeRate(exchangeRateFilter);

		assertNotNull(respuesta);
	}

	@Test
	public void testGetExchangeRateSale() {
		final DTOIntExchangeRateFilter exchangeRateFilter = new DTOIntExchangeRateFilter();
		exchangeRateFilter.setCurrencyId("USD");
		exchangeRateFilter.setCustomerId("1026283049");
		exchangeRateFilter.setPurchaseAmount(null);
		exchangeRateFilter.setSaleAmount(new BigDecimal(100000));

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

		Mockito.when(exchangeRateDAO.getExchangeRate(exchangeRateFilter)).thenReturn(dtoExchangeRate);
		final DTOIntExchangeRate respuesta = srv.getExchangeRate(exchangeRateFilter);

		assertNotNull(respuesta);
	}

	@Test(expected = BusinessServiceException.class)
	public void testGetExchangeCurrencyID() {

		final DTOIntExchangeRateFilter exchangeRateFilter = new DTOIntExchangeRateFilter();
		exchangeRateFilter.setCustomerId("1026283049");
		exchangeRateFilter.setPurchaseAmount(new BigDecimal(100000));
		exchangeRateFilter.setSaleAmount(null);

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

		Mockito.when(exchangeRateDAO.getExchangeRate(exchangeRateFilter)).thenReturn(dtoExchangeRate);
		final DTOIntExchangeRate respuesta = srv.getExchangeRate(exchangeRateFilter);

		assertNotNull(respuesta);

	}

	@Test(expected = BusinessServiceException.class)
	public void testGetExchangeCustomerID() {

		final DTOIntExchangeRateFilter exchangeRateFilter = new DTOIntExchangeRateFilter();
		exchangeRateFilter.setCurrencyId("USD");
		exchangeRateFilter.setPurchaseAmount(new BigDecimal(100000));
		exchangeRateFilter.setSaleAmount(null);

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

		Mockito.when(exchangeRateDAO.getExchangeRate(exchangeRateFilter)).thenReturn(dtoExchangeRate);
		final DTOIntExchangeRate respuesta = srv.getExchangeRate(exchangeRateFilter);

		assertNotNull(respuesta);

	}
}
