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

		log.info("Into getlistCreCardCharges...");
		log.info("getlistCreCardCharges params:" + filter);

		DTOIntCardCharge dtoIntCardCharge = new DTOIntCardCharge();
		List<DTOIntCardCharge> cardChargetDtoList = new ArrayList<DTOIntCardCharge>();

		try {
			FormatoOZECNPE0 FormatoOZECNPE0 = new FormatoOZECNPE0();
			FormatoOZECNPE0.setIdusuar(filter.getCustomerId());
			FormatoOZECNPE0.setFechain(filter.getStartDate());
			FormatoOZECNPE0.setFechafi(filter.getEndDate());

			PeticionTransaccionOznp peticion = new PeticionTransaccionOznp();

			peticion.getCuerpo().getPartes().add(FormatoOZECNPE0);
			log.info("getlistCreCardCharges formato de entrada:" + peticion);
			RespuestaTransaccionOznp respuesta = transaccionOznp.invocar(peticion);
			log.info("getlistCreCardCharges respuesta:" + respuesta);

			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null) {
				throw exception;
			}

			List<CopySalida> outputCopies = respuesta.getCuerpo().getPartes(CopySalida.class);

			if (!outputCopies.isEmpty()) {
				for (CopySalida outputCopy : outputCopies) {
					 FormatoOZECNPS0 formatoSalida = outputCopy.getCopy(FormatoOZECNPS0.class);
					
					dtoIntCardCharge = customerMapper.map(formatoSalida);
					cardChargetDtoList.add(dtoIntCardCharge);
				}
			} else {
				throw new BusinessServiceException(EnumError.NO_DATA.getAlias());
			}
		} catch (BusinessServiceException bse) {
			log.error("BusinessServiceException - Transaction error happened: " + bse.getMessage());
			throw bse;
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("getlistCreCardCharges response: " + cardChargetDtoList);
		return cardChargetDtoList;
	}

	@Override
	public DTOIntCustomer getCustomer(String customerId) throws BusinessServiceException {
		log.info("CustDAO: Into getCustomer...");
		log.info("CustDAO: getCustomer params(customerId):" + customerId);
		return txGetCustomer.invoke(customerId);
	}

}
