package com.bbva.czic.exchangerate.dao;

import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateFilter;

public interface ExchangeRateDAO {

	public DTOIntExchangeRate getExchangeRate(DTOIntExchangeRateFilter dtoExchangeRateFilter);

}
