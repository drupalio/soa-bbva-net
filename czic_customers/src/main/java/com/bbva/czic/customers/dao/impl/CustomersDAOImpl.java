package com.bbva.czic.customers.dao.impl;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.business.impl.SrvIntCustomers;
import com.bbva.czic.customers.dao.CustomersDAO;
import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPE0;
import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPS0;
import com.bbva.czic.customers.dao.model.oznp.PeticionTransaccionOznp;
import com.bbva.czic.customers.dao.model.oznp.RespuestaTransaccionOznp;
import com.bbva.czic.customers.dao.tx.TxGetCustomer;
import com.bbva.czic.customers.dao.tx.TxListAccountMovementsResume;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Component(value = "customers-dao")
public class CustomersDAOImpl implements CustomersDAO {

	private static final String FILTERERROR = null;

	@Resource(name = "tx-get-customer")
	private TxGetCustomer txGetCustomer;

	@Resource(name = "txListAccountMovementsResume")
	private TxListAccountMovementsResume txListAccountMovementsResume;

	@Resource(name = "transaccionOznp")
	private InvocadorTransaccion<PeticionTransaccionOznp, RespuestaTransaccionOznp> transaccionOznp;

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntCustomers.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Override
	public List<DTOIntAccMovementsResume> getlistAccountsMovementsResume(DTOIntAccMovementsResumesFilter filter)
			throws BusinessServiceException {

		log.info("Into getListAccountsMovementsResume...");
		log.info("getListAccountsMovementsResume params:" + filter);
		return txListAccountMovementsResume.invoke(filter);
	}

	@Override
	public List<DTOIntCardCharge> getlistCreCardCharges(DTOIntAccMovementsResumesFilter filter)
			throws BusinessServiceException {

		return null;
	}

	@Override
	public DTOIntCustomer getCustomer(String customerId) throws BusinessServiceException {
		log.info("CustDAO: Into getCustomer...");
		log.info("CustDAO: getCustomer params(customerId):" + customerId);
		return txGetCustomer.invoke(customerId);
	}

}
