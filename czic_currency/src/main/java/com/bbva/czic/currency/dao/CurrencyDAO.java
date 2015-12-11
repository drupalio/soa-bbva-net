package com.bbva.czic.currency.dao;

import com.bbva.czic.currency.business.dto.DTOIntCurrency;

import java.util.List;

public interface CurrencyDAO {

	public List<DTOIntCurrency> listCurrencies();
	
}

