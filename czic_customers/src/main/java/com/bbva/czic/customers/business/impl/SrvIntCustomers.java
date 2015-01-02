package com.bbva.czic.customers.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.customers.business.ISrvIntCustomers;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.dao.CustomersDAO;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.mapper.CustomerMapper;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Service
public class SrvIntCustomers implements ISrvIntCustomers {

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvIntCustomers.class, "META-INF/spring/i18n/log/mensajesLog");

	private CustomersDAO customersDao;

	@Resource(name = "CustomerMapper")
	private CustomerMapper customerMapper;
	@Autowired
	BusinessServicesToolKit bussinesToolKit;
	
/***************************AccountMovement***************************************/
	@Override
	public List<AccMovementsResume> getlistAccountsMovementsResume(
			String idUser, String fechain, String fechafi)
			throws BusinessServiceException {
		AccMovementsResume accountMovementsResume = null;
		try {

			if (idUser == null)
				throw new BusinessServiceException(
						"wrongParametersListAccountsMovementsResume");

			List<AccMovementsResume> listMovements = new ArrayList<AccMovementsResume>();
			// accountMovementsResume.getCustomerId(idUser);

			List<DTOIntAccMovementsResume> dtoIntCAccMovementsResumes = customersDao
					.getlistAccountsMovementsResume(idUser, fechain, fechafi);

			for (DTOIntAccMovementsResume item : dtoIntCAccMovementsResumes) {

				accountMovementsResume = new AccMovementsResume();

				accountMovementsResume = customerMapper.map(item,
						AccMovementsResume.class);
				listMovements.add(accountMovementsResume);

			}
			return listMovements;
		} catch (Exception e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}
/***************************CardCharge***************************************/
	@Override
	
	public List<CardCharge> getlistCreditCharges(String numproduct,
			String fechain, String fechafi) throws BusinessServiceException {
		CardCharge cardCharge2 = null;
		try {

			if (numproduct == null)
				throw new BusinessServiceException(
						"wrongParametersListCreditCardsCharges");

			List<CardCharge> listCardCharge = new ArrayList<CardCharge>();
			cardCharge2.getCustomerId(numproduct);

			List<DTOIntCardCharge> dtoIntCardCharges = customersDao
					.getlistCreCardCharges(numproduct, fechain, fechafi);

			for (DTOIntCardCharge item : dtoIntCardCharges) {

				cardCharge2 = new CardCharge();

				cardCharge2 = customerMapper.map(item, CardCharge.class);
				listCardCharge.add(cardCharge2);

			}

			return listCardCharge;
		} catch (Exception e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}
}
