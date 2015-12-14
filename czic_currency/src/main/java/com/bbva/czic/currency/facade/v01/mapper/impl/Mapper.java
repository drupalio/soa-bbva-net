package com.bbva.czic.currency.facade.v01.mapper.impl;

import com.bbva.czic.currency.facade.v01.mapper.IMapper;
import org.springframework.beans.BeanUtils;

import com.bbva.czic.dto.net.Currency;
import com.bbva.czic.currency.business.dto.DTOIntCurrency;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "CurrencyMapper")
public class Mapper implements IMapper{


	@Override
	public List<Currency> MapOutListCurrency(List<DTOIntCurrency> listDtoCurrency) {
		List<Currency> currencyList=new ArrayList<Currency>();
		for(int i=0; i< listDtoCurrency.size(); i++){
			DTOIntCurrency dtoIntCurrency=listDtoCurrency.get(i);
			Currency currency=new Currency();
			currency.setId(dtoIntCurrency.getId());
			currency.setName(dtoIntCurrency.getName());
			currencyList.add(currency);
		}
		return currencyList;
	}
}

