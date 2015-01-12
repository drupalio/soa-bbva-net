package com.bbva.czic.customers.business.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.czic.customers.business.dto.DTOIntFilterCustomerResumes;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.customers.business.ISrvIntCustomers;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.dao.CustomersDAO;
import com.bbva.czic.customers.dao.mapper.ICustomerMapper;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Service
public class SrvIntCustomers implements ISrvIntCustomers {

	private static final String FILTERERROR = null;

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvIntCustomers.class, "META-INF/spring/i18n/log/mensajesLog");

	@Resource(name = "customers-dao-impl")
	private CustomersDAO customersDao;

	@Resource(name="customerMapper")
	private ICustomerMapper customerMapper;

	@Autowired
	private BusinessServicesToolKit bussinesToolKit;


	public void setCustomerMapper(ICustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}

	public void setCustomersDao(CustomersDAO customersDao) {
		this.customersDao = customersDao;
	}

	/***************************AccountMovement***************************************/
	@Override
	public List<AccMovementsResume> getlistAccountsMovementsResume(String customerId,
			DTOIntFilterCustomerResumes filter) throws BusinessServiceException {
		log.info("Into getlistAccountsMovementsResume... ");
		log.info("getlistAccountsMovementsResume params: " + filter);

		try {
			if(filter != null){
				List<AccMovementsResume> listMovements = new ArrayList<AccMovementsResume>();
				List<DTOIntAccMovementsResume> dtoIntAccMovementsResumes = customersDao
						.getlistAccountsMovementsResume(filter);

				for (DTOIntAccMovementsResume item : dtoIntAccMovementsResumes) {
					listMovements.add(customerMapper.map(item));
				}
				return listMovements;
			}else{
				throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
			}
		} catch (BusinessServiceException bse) {
			log.error("BusinessServiceException - Error during platform: " + bse);
			throw bse;
		} catch (Exception e) {
			log.error("Exception - Unhandled error: " + e);
			throw new BusinessServiceException(e.getMessage());
		}

	}
	/***************************CardCharge***************************************/
	@Override
	public List<CardCharge> getlistCreditCharges(String customerId,
			final DTOIntFilterCustomerResumes filter) throws BusinessServiceException {
		log.info("Into getlistCreditCharges... ");
		log.info("getlistCreditCharges params: " + filter);

		try {
			if(filter != null){
				List<CardCharge> listCardCharge = new ArrayList<CardCharge>();

				List<DTOIntCardCharge> dtoIntCardCharges = customersDao
						.getlistCreCardCharges(filter);

				for (DTOIntCardCharge item : dtoIntCardCharges) {
					listCardCharge.add(customerMapper.map(item 	));
				}

				return listCardCharge;
			}else{
				throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
			}
		} catch (Exception e) {
			throw new BusinessServiceException(e.getMessage());
		}

	}
}
     
	
