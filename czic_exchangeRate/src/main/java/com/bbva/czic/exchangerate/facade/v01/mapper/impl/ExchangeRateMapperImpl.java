package com.bbva.czic.exchangerate.facade.v01.mapper.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.bbva.czic.dto.net.ExchangeRate;
import com.bbva.czic.dto.net.ExchangeRateAssessments;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateAssessments;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateFilter;
import com.bbva.czic.exchangerate.facade.v01.mapper.IExchangeRateMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;

@Mapper(value = "exchange-mapper")
public class ExchangeRateMapperImpl implements IExchangeRateMapper {

	@Override
	public ExchangeRate map(DTOIntExchangeRate dtoIntExchangeRate) {

		ExchangeRate exchangeRate = new ExchangeRate();

		dtoIntExchangeRate.getExchangeRateAssessments();
		ExchangeRateAssessments exchangeRateAssessments = new ExchangeRateAssessments();
		List<ExchangeRateAssessments> listAssessments = new ArrayList<ExchangeRateAssessments>();

		for (DTOIntExchangeRateAssessments assesments : dtoIntExchangeRate.getExchangeRateAssessments()) {
			exchangeRateAssessments.setType(assesments.getType());
			exchangeRateAssessments.setValue(assesments.getValue());
			listAssessments.add(exchangeRateAssessments);
		}
		exchangeRate.setExchangeRateAssessments(listAssessments);

		return exchangeRate;
	}

	@Override
	public DTOIntExchangeRateFilter map(String exchangeRateCurrency, String customerId, BigDecimal purchaseValueAmount,
			BigDecimal saleValueAmount) {

		DTOIntExchangeRateFilter dtoIntExchangeRateFilter = new DTOIntExchangeRateFilter();
		dtoIntExchangeRateFilter.setCurrencyId(exchangeRateCurrency);
		dtoIntExchangeRateFilter.setCustomerId(customerId);
		dtoIntExchangeRateFilter.setPurchaseAmount(purchaseValueAmount);
		dtoIntExchangeRateFilter.setSaleAmount(saleValueAmount);

		return dtoIntExchangeRateFilter;
	}

}
