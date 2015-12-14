package com.bbva.czic.currency.business.impl;

import java.util.List;

import com.bbva.czic.currency.dao.CurrencyDAO;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

import com.bbva.czic.currency.business.dto.DTOIntCurrency;
import com.bbva.czic.currency.business.ISrvIntCurrency;

import javax.annotation.Resource;


@Service
public class SrvIntCurrency implements ISrvIntCurrency {
	
	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntCurrency.class,"META-INF/spring/i18n/log/mensajesLog");

	@Resource(name = "CurrencyDAO")
	CurrencyDAO currencyDAO;

	@Autowired
	BusinessServicesToolKit bussinesToolKit;
	
	
	@Override
	public List<DTOIntCurrency> listCurrencies() {

		List<DTOIntCurrency> dtoIntCurrencyList=currencyDAO.listCurrencies();

		DtoValidator.validate(dtoIntCurrencyList);

		return dtoIntCurrencyList;
	}

	

}
