package com.bbva.czic.customers.business.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.czic.customers.business.dto.*;
import org.springframework.stereotype.Service;

import com.bbva.czic.customers.business.ISrvIntCustomers;
import com.bbva.czic.customers.dao.CustomersDAO;
import com.bbva.czic.dto.net.Customer;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

@Service
public class SrvIntCustomers implements ISrvIntCustomers {

	private static final String FILTERERROR = null;

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvIntCustomers.class, "META-INF/spring/i18n/log/mensajesLog");

	@Resource(name = "customers-dao")
	private CustomersDAO customersDao;

	public void setCustomersDao(CustomersDAO customersDao) {
		this.customersDao = customersDao;
	}

	/**
	 *
	 * @param accMovementResumeFilter
	 * @return
	 * @throws BusinessServiceException
	 */
	@Override
	public List<DTOIntAccMovementsResume> getListAccountsMovementsResume(
			final DTOIntAccMovementsResumesFilter accMovementResumeFilter
	) {
		log.info("Into getListAccountsMovementsResume... ");
		log.info("getListAccountsMovementsResume params: " + accMovementResumeFilter);

		// 1. Validate DtoIntFilterAccount
		DtoValidator.validate(accMovementResumeFilter);

		// 2. Get response
		final List<DTOIntAccMovementsResume> accMovementsResumes = customersDao.listAccountsMovementsResume(accMovementResumeFilter);

		// 3. Validate output
		DtoValidator.validate(accMovementResumeFilter);

		return accMovementsResumes;
	}

	/**
	 *
	 * @return
	 * @throws BusinessServiceException
	 */
	@Override
	public List<DTOIntCardCharge> listCreditCharges(final DTOIntCardChargeFilter cardChargeFilter) {
		log.info("Into listCreditCharges... ");
		log.info("listCreditCharges params: " + cardChargeFilter.toString());

		// 1. Validate DtoIntFilterAccount
		DtoValidator.validate(cardChargeFilter);

		// 2. Get response
		final List<DTOIntCardCharge> intCardCharges = customersDao.listCreditCardCharges(cardChargeFilter);

		// 3. Validate output
		DtoValidator.validate(intCardCharges);

		return intCardCharges;
	}

	/**
	 *
	 * @param customerId
	 * @return
	 * @throws BusinessServiceException
	 */
	@Override
	public Customer getCustomer(String customerId)
			throws BusinessServiceException {
		log.info("SrvInt: Into getCustomer... ");
		log.info("SrvInt: getCustomerParams(customerId): " + customerId);
		// 1. Validate parameter
		if (customerId == null || customerId.trim().isEmpty()) {
			throw new BusinessServiceException(
					EnumError.WRONG_PARAMETERS.getAlias());
		}
		// 2. Get response
		DTOIntCustomer dtoIntCustomer = customersDao.getCustomer(customerId);
		// 3. Validate output
		DtoValidator.validate(dtoIntCustomer);
		log.info("SrvInt: gettingIntoMapper: " + dtoIntCustomer);
		return null; //customerMapper.mapAccMovementsResume(dtoIntCustomer);

	}

	public Customer addChannel(final String customerId, final String channelId){
		DTOIntCustomer dtoIntCustomer = customersDao.addChannel(customerId, channelId);
	//	DtoValidator.validate(dtoIntCustomer);
		log.info("SrvInt: addChannel: ");
		return null;
	}
}
