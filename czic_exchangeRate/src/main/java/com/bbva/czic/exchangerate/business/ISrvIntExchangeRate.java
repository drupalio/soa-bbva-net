package com.bbva.czic.exchangerate.business;

import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateFilter;

public interface ISrvIntExchangeRate {

	public DTOIntExchangeRate getExchangeRate(DTOIntExchangeRateFilter dtoIntExchangeRateFilter);

}