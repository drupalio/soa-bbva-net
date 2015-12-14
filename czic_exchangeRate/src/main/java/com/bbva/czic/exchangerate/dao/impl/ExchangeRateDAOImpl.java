package com.bbva.czic.exchangerate.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateAssessments;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateFilter;
import com.bbva.czic.exchangerate.dao.ExchangeRateDAO;

@Component(value = "exchangeRate-dao")
public class ExchangeRateDAOImpl implements ExchangeRateDAO {

	@Override
	public DTOIntExchangeRate getExchangeRate(DTOIntExchangeRateFilter dtoExchangeRateFilter) {
		DTOIntExchangeRate dtoIntExchangeRate = new DTOIntExchangeRate();
		List<DTOIntExchangeRateAssessments> listRates = new ArrayList<DTOIntExchangeRateAssessments>();
		DTOIntExchangeRateAssessments rates = new DTOIntExchangeRateAssessments();
		rates.setType("TasaDivisaUSD");
		rates.setValue(new BigDecimal(123));
		listRates.add(rates);

		rates = new DTOIntExchangeRateAssessments();
		rates.setType("TasaUSDMoneda");
		rates.setValue(new BigDecimal(1234));
		listRates.add(rates);

		rates = new DTOIntExchangeRateAssessments();
		rates.setType("TasaDivisaMoneda");
		rates.setValue(new BigDecimal(12345));
		listRates.add(rates);

		rates = new DTOIntExchangeRateAssessments();
		rates.setType("TotalPesos");
		rates.setValue(new BigDecimal(12345));
		listRates.add(rates);
		dtoIntExchangeRate.setExchangeRateAssessments(listRates);
		return dtoIntExchangeRate;
	}

}
