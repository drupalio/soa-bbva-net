package com.bbva.czic.customers.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scala.metaprogramming.Mirror.Public;

import com.bbva.czic.customers.business.ISrvIntCustomers;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.dao.CustomersDAO;
import com.bbva.czic.customers.facade.v01.mapper.Mapper;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.mapper.CustomerMapper;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Service
public class SrvIntCustomers implements ISrvIntCustomers {

	private static final String FILTERERROR = null;

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvIntCustomers.class, "META-INF/spring/i18n/log/mensajesLog");

	private CustomersDAO customersDao;

	@Resource(name = "CustomerMapper")
	private CustomerMapper customerMapper;
	@Autowired
	BusinessServicesToolKit bussinesToolKit;
	
	
/***************************AccountMovement***************************************/
	@Override
	public List<AccMovementsResume> getlistAccountsMovementsResume(String idUser,
			String filter) throws BusinessServiceException {
		
		AccMovementsResume accountMovementsResume = null;
		try {

			if (idUser == null)
				throw new BusinessServiceException(
						"wrongParametersListAccountsMovementsResume");

			List<AccMovementsResume> listMovements = new ArrayList<AccMovementsResume>();
		
			
			if (filter != null && !filter.contentEquals("null")) 
				log.info("A query string (filter) has been sended: " + filter);
				SearchCondition<DTOIntAccMovementsResume> sc;
				String property = null;
				String condition = null;
				String value = null;

			
				try {
					sc = new FiqlParser<DTOIntAccMovementsResume>(DTOIntAccMovementsResume.class).parse(filter);

					final List<PrimitiveStatement> splitDataFilter = bussinesToolKit.getDataFromFilter(sc);
					for (PrimitiveStatement st: splitDataFilter) {
						property = st.getProperty();
						condition = st.getCondition().toString();
						value = st.getValue().toString();
					}

					/*
					final String pattern = bussinesToolKit.matchesPatternFromFilter(SERVICENAME, filter);
					if (pattern != null) {
						log.info("The pattern is: " + pattern);
					}
					*/
				} catch (SearchParseException e) {
					log.error("SearchParseException - The query string (filter) has failed: " + e);
					throw new BusinessServiceException(FILTERERROR, filter, e.getMessage());
					
				}
				
				List<DTOIntCardCharge> dtoIntCardCharges = customersDao
						.getlistCreCardCharges(idUser, filter);

				for (DTOIntCardCharge item : dtoIntCardCharges) {

					accountMovementsResume = new AccMovementsResume();

					accountMovementsResume = customerMapper.map(item, AccMovementsResume.class);
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
			final String filter) throws BusinessServiceException {
		CardCharge cardCharge2 = null;
		try {

			if (numproduct == null)
				throw new BusinessServiceException(
						"wrongParametersListCreditCardsCharges");

			List<CardCharge> listCardCharge = new ArrayList<CardCharge>();
			//cardCharge2.getCustomerId(numproduct);
			
			if (filter != null && !filter.contentEquals("null")) 
				log.info("A query string (filter) has been sended: " + filter);
				SearchCondition<DTOIntCardCharge> sc;
				String property = null;
				String condition = null;
				String value = null;
				
				try {
					sc = new FiqlParser<DTOIntCardCharge>(DTOIntCardCharge.class).parse(filter);

					final List<PrimitiveStatement> splitDataFilter = bussinesToolKit.getDataFromFilter(sc);
					for (PrimitiveStatement st: splitDataFilter) {
						property = st.getProperty();
						condition = st.getCondition().toString();
						value = st.getValue().toString();
					}

					/*
					final String pattern = bussinesToolKit.matchesPatternFromFilter(SERVICENAME, filter);
					if (pattern != null) {
						log.info("The pattern is: " + pattern);
					}
					*/
				} catch (SearchParseException e) {
					log.error("SearchParseException - The query string (filter) has failed: " + e);
					throw new BusinessServiceException(FILTERERROR, filter, e.getMessage());
				}
			
			List<DTOIntCardCharge> dtoIntCardCharges = customersDao
					.getlistCreCardCharges(numproduct, filter);

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
     
	
