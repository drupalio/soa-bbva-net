package com.bbva.czic.exchangerate.dao.impl;

import org.springframework.stereotype.Repository;

import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateFilter;
import com.bbva.czic.exchangerate.dao.ExchangeRateDAO;

@Repository(value = "exchangeRate-dao")
public class ExchangeRateDAOImpl implements ExchangeRateDAO {

	@Override
	public DTOIntExchangeRate getExchangeRate(DTOIntExchangeRateFilter dtoExchangeRateFilter) {
		// TODO Auto-generated method stub
		return null;
	}

}
