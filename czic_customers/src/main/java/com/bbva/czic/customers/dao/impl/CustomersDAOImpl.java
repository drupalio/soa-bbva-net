package com.bbva.czic.customers.dao.impl;

import com.bbva.czic.customers.business.dto.*;
import com.bbva.czic.customers.business.impl.SrvIntCustomers;
import com.bbva.czic.customers.dao.CustomersDAO;
import com.bbva.czic.customers.dao.model.oznp.PeticionTransaccionOznp;
import com.bbva.czic.customers.dao.model.oznp.RespuestaTransaccionOznp;
import com.bbva.czic.customers.dao.tx.TxGetCustomer;
import com.bbva.czic.customers.dao.tx.TxListAccountMovementsResume;
import com.bbva.czic.customers.dao.tx.TxVerifyCustomer;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component(value = "customers-dao")
public class CustomersDAOImpl implements CustomersDAO {

	private static final String FILTERERROR = null;

	@Resource(name = "tx-get-customer")
	private TxGetCustomer txGetCustomer;

	@Resource(name = "txListAccountMovementsResume")
	private TxListAccountMovementsResume txListAccountMovementsResume;

	@Resource(name = "tx-verify-customer")
	private TxVerifyCustomer txVerifyCustomer;

	@Resource(name = "transaccionOznp")
	private InvocadorTransaccion<PeticionTransaccionOznp, RespuestaTransaccionOznp> transaccionOznp;

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
		return null;
	}

	@Override
	public DTOIntCustomer getCustomer(String customerId) throws BusinessServiceException {
		log.info("CustDAO: Into getCustomer...");
		log.info("CustDAO: getCustomer params(customerId):" + customerId);
		return txGetCustomer.invoke(customerId);
	}

	@Override
	public void verifyCustomer(DTOIntCustomerOperation customerOperation) {
		log.info("CustDAO: Into verifyCustomer...");
		log.info("CustDAO: verifyCustomer params(customerOperation):" + customerOperation);
		txVerifyCustomer.invoke(customerOperation);
	}
	
	public DTOIntCustomer addChannel(final String customerId, final String channelId){
		return null;
	}

}
