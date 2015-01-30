package com.bbva.czic.customers.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.czic.customers.business.dto.*;
import org.springframework.stereotype.Service;

import com.bbva.czic.customers.business.ISrvIntCustomers;
import com.bbva.czic.customers.dao.CustomersDAO;
import com.bbva.czic.dto.net.CardCharge;
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
			final DTOIntAccMovementsResumesFilter accMovementResumeFilter) throws BusinessServiceException {
		log.info("Into getListAccountsMovementsResume... ");
		log.info("getListAccountsMovementsResume params: " + accMovementResumeFilter);

		// 1. Validate DtoIntFilterAccount
		DtoValidator.validate(accMovementResumeFilter);

		// 2. Get response
		final List<DTOIntAccMovementsResume> accMovementsResumes = customersDao.getlistAccountsMovementsResume(accMovementResumeFilter);

		// 3. Validate output
		DtoValidator.validate(accMovementResumeFilter);

		return accMovementsResumes;
	}

	/**
	 *
	 * @param customerId
	 * @param filter
	 * @return
	 * @throws BusinessServiceException
	 */
	@Override
	public List<CardCharge> getlistCreditCharges(String customerId,
			final DTOIntAccMovementsResumesFilter filter)
			throws BusinessServiceException {
		log.info("Into getlistCreditCharges... ");
		log.info("getlistCreditCharges params: " + filter);

		List<CardCharge> listCardCharge = new ArrayList<CardCharge>();
		filter.setCustomerId(customerId);

		try {
			// 1. Validate DtoIntFilterAccount
			DtoValidator.validate(filter);
			// 2. Get response
			List<DTOIntCardCharge> dtoIntCardCharges = customersDao
					.getlistCreCardCharges(filter);
			for (DTOIntCardCharge item : dtoIntCardCharges) {
				//listCardCharge.add(customerMapper.map(item));
			}
			log.info(" DAO: getListCreditChargesResponse: " + dtoIntCardCharges);
			// 3. Validate output
			DtoValidator.validate(dtoIntCardCharges);
			return listCardCharge;
		} catch (BusinessServiceException bse) {
			log.error("BusinessServiceException - Error during platform: "
					+ bse);
			throw bse;
		}

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
		return null; //customerMapper.map(dtoIntCustomer);

	}

	@Override
	public void verifyCustomer(DTOIntCustomerOperation customerOperation) {

		DtoValidator.validate(customerOperation);


	}
}
