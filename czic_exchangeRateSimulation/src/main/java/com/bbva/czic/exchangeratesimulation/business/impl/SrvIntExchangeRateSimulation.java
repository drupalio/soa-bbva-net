package com.bbva.czic.exchangeratesimulation.business.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.exchangeratesimulation.business.ISrvIntExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.business.dto.DTOIntExchangeRateSimulation;
import com.bbva.czic.exchangeratesimulation.dao.ExchangeRateSimulationDAO;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Service
public class SrvIntExchangeRateSimulation implements ISrvIntExchangeRateSimulation {

	private static Log log = LogFactory.getLog(SrvIntExchangeRateSimulation.class);

	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Resource(name = "exchangeRateSimulation-dao")
	private ExchangeRateSimulationDAO exchangeRateSimulateDAO;

	@Override
	public DTOIntExchangeRateSimulation getExchangeRateSimulation(DTOIntExchangeRateSimulation dtoExchangeRateSimulation) {

		DtoValidator.validate(dtoExchangeRateSimulation);

		log.info("SrvInt: getExchangeRateSimultaion");
		return exchangeRateSimulateDAO.getExchangeRateSimulation(dtoExchangeRateSimulation);
	}

}
