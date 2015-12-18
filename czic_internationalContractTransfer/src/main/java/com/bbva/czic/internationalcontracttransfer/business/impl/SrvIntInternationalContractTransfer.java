package com.bbva.czic.internationalcontracttransfer.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.internationalcontracttransfer.business.ISrvIntInternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntFilterInternationalContractTransfers;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.dao.InternationalContractTransferDAO;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Service
public class SrvIntInternationalContractTransfer implements ISrvIntInternationalContractTransfer {

	private static Log log = LogFactory.getLog(SrvIntInternationalContractTransfer.class);

	@Autowired
	BusinessServicesToolKit bussinesToolKit;
	
	@Resource(name = "internationalContractTransfer-dao")
	private InternationalContractTransferDAO internationalContractTransferDAO;

	@Override
	public List<DTOIntInternationalContractTransfer> listInternationalContractTransfer(
			DTOIntFilterInternationalContractTransfers filterInternationalContractTransfer) {
		// 1. Validate DTOIntExchangeRateFilter
		DtoValidator.validate(filterInternationalContractTransfer);
		// 2. Get response
		final List<DTOIntInternationalContractTransfer> result = internationalContractTransferDAO.listInternationalContractTransfer(filterInternationalContractTransfer);

		// 3. Validate output
		DtoValidator.validate(result);

		log.info(" getInternationalContractTransfer ");
		return result;
	}

}
