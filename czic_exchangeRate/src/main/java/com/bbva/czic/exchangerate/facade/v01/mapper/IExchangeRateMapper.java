package com.bbva.czic.exchangerate.facade.v01.mapper;

import java.math.BigDecimal;

import com.bbva.czic.dto.net.ExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateFilter;

public interface IExchangeRateMapper {

	public ExchangeRate map(DTOIntExchangeRate dtoIntExchangeRate);

	public DTOIntExchangeRateFilter map(String exchangeRateCurrency, String customerId, BigDecimal purchaseValueAmount,
			BigDecimal saleValueAmount);

}
