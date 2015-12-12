package com.bbva.czic.exchangerate.facade.v01;

import java.math.BigDecimal;

import com.bbva.czic.dto.net.ExchangeRate;

public interface ISrvExchangeRateV01 {

	public ExchangeRate getExchangeRate(String exchangeRateCurrency, String customerId, BigDecimal purchaseValueAmount,
			BigDecimal saleValueAmount);

}