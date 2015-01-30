package com.bbva.czic.customers.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.customers.business.ISrvIntCustomers;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.business.dto.DTOIntFilterCustomerResumes;
import com.bbva.czic.customers.dao.CustomersDAO;
import com.bbva.czic.customers.dao.mapper.ICustomerMapper;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Service
public class SrvIntCustomers implements ISrvIntCustomers {

	private static final String FILTERERROR = null;

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvIntCustomers.class, "META-INF/spring/i18n/log/mensajesLog");

	@Resource(name = "customers-dao")
	private CustomersDAO customersDao;

	@Resource(name = "customerMapper")
	private ICustomerMapper customerMapper;

	@Autowired
	private BusinessServicesToolKit bussinesToolKit;

	public void setCustomerMapper(ICustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}

	public void setCustomersDao(CustomersDAO customersDao) {
		this.customersDao = customersDao;
	}

	/*************************** AccountMovement ***************************************/
	@Override
	public List<AccMovementsResume> getlistAccountsMovementsResume(
			String customerId, final DTOIntFilterCustomerResumes filter)
			throws BusinessServiceException {
		log.info("Into getlistAccountsMovementsResume... ");
		log.info("getlistAccountsMovementsResume params: " + filter);

		List<AccMovementsResume> listMovements = new ArrayList<AccMovementsResume>();
		filter.setCustomerId(customerId);
		// 1. Validate DtoIntFilterAccount
		DtoValidator.validate(filter);
		// 2. Get response
		List<DTOIntAccMovementsResume> dtoIntAccMovementsResumes = customersDao
				.getlistAccountsMovementsResume(filter);
		for (DTOIntAccMovementsResume item : dtoIntAccMovementsResumes) {
			listMovements.add(customerMapper.map(item));
		}
		log.info("getlistAccountsMovementsResume dao response: "
				+ dtoIntAccMovementsResumes);
		// 3. Validate output
		DtoValidator.validate(dtoIntAccMovementsResumes);
		return listMovements;
	}

	/*************************** CardCharge ***************************************/
	@Override
	public List<CardCharge> getlistCreditCharges(String customerId,
			final DTOIntFilterCustomerResumes filter)
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
				listCardCharge.add(customerMapper.map(item));
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

	/*************************** Customer ***************************************/
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
		return customerMapper.map(dtoIntCustomer);

	}

	public Customer addChannel(final String customerId, final String channelId){
		DTOIntCustomer dtoIntCustomer = customersDao.addChannel(customerId, channelId);
	//	DtoValidator.validate(dtoIntCustomer);
		log.info("SrvInt: addChannel: ");
		return null;
	}
}
