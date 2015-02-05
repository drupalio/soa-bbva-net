package com.bbva.czic.customers.dao.impl;

import com.bbva.czic.customers.business.dto.*;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.czic.customers.dao.tx.*;
import com.bbva.czic.customers.business.dto.DTOIntCustomerFilter;
import org.springframework.stereotype.Component;

import com.bbva.czic.customers.business.impl.SrvIntCustomers;
import com.bbva.czic.customers.dao.CustomersDAO;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;


@Component(value = "customers-dao")
public class CustomersDAOImpl implements CustomersDAO {

	private static final String FILTERERROR = null;

	@Resource(name = "tx-get-customer")
	private TxGetCustomer txGetCustomer;

	@Resource(name = "txListAccountMovementsResume")
	private TxListAccountMovementsResume txListAccountMovementsResume;

	@Resource(name = "txListCardCharges")
	private TxListCardCharges txListCardCharges;

	/**
	 * OZNW
	 */
	@Resource(name = "tx-add-channel")
	private TxAddChannel txAddChannel;

	@Resource(name = "tx-verify-customer")
	private TxVerifyCustomer txVerifyCustomer;

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntCustomers.class, "META-INF/spring/i18n/log/mensajesLog");

	@Override
	public List<DTOIntAccMovementsResume> listAccountsMovementsResume(DTOIntAccMovementsResumesFilter filter) {

		log.info("Into getListAccountsMovementsResume...");
		log.info("getListAccountsMovementsResume params:" + filter);
		return txListAccountMovementsResume.invoke(filter);
	}

	@Override
	public List<DTOIntCardCharge> listCreditCardCharges(DTOIntCardChargeFilter cardChargeFilter) {
		log.info("Into getListAccountsMovementsResume...");
		log.info("getListAccountsMovementsResume params:" + cardChargeFilter);
		return txListCardCharges.invoke(cardChargeFilter);
	}

	@Override
	public DTOIntCustomer getCustomer(DTOIntCustomerFilter customerFilter) throws BusinessServiceException {
		log.info("CustDAO: Into getCustomer...");
		log.info("CustDAO: getCustomer params(customerId):" + customerFilter);
		return txGetCustomer.invoke(customerFilter);
	}

	@Override
	public void verifyCustomer(DTOIntCustomerOperation customerOperation) {
		log.info("CustDAO: Into verifyCustomer...");
		log.info("CustDAO: verifyCustomer params(customerOperation):" + customerOperation);
		txVerifyCustomer.invoke(customerOperation);
	}

	public void addChannel(final DTOIntAddChannel dtoIntAddChannel){
		log.info("CustDAO: Into addChannel...");
		txAddChannel.invoke(dtoIntAddChannel);
	}

}
