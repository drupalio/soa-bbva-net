package com.bbva.czic.exchangerate.business.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.exchangerate.business.ISrvIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRate;
import com.bbva.czic.exchangerate.business.dto.DTOIntExchangeRateFilter;
import com.bbva.czic.exchangerate.dao.ExchangeRateDAO;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Service
public class SrvIntExchangeRate implements ISrvIntExchangeRate {

	private static Log log = LogFactory.getLog(SrvIntExchangeRate.class);

	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Resource(name = "exchangeRate-dao")
	private ExchangeRateDAO exchangeRateDAO;

	@Override
	public DTOIntExchangeRate getExchangeRate(DTOIntExchangeRateFilter dtoIntExchangeRateFilter) {
		// 1. Validate DtoIntFilterAccount
		DtoValidator.validate(dtoIntExchangeRateFilter);
		// 2. Get response
		final DTOIntExchangeRate result = exchangeRateDAO.getExchangeRate(dtoIntExchangeRateFilter);

		// 3. Validate output
		DtoValidator.validate(result);

		log.info(" getExchangeRate ");
		return result;
	}

}
