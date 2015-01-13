package com.bbva.czic.customers.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.czic.customers.business.dto.DTOIntFilterCustomerResumes;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.business.impl.SrvIntCustomers;
import com.bbva.czic.customers.dao.model.ozno.FormatoOZECNOE0;
import com.bbva.czic.customers.dao.model.ozno.FormatoOZECNOS0;
import com.bbva.czic.customers.dao.model.ozno.PeticionTransaccionOzno;
import com.bbva.czic.customers.dao.model.ozno.RespuestaTransaccionOzno;
import com.bbva.czic.customers.dao.model.ozno.TransaccionOzno;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQE0;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQS0;
import com.bbva.czic.customers.dao.model.oznq.PeticionTransaccionOznq;
import com.bbva.czic.customers.dao.model.oznq.RespuestaTransaccionOznq;
import com.bbva.czic.customers.dao.model.oznq.TransaccionOznq;
import com.bbva.czic.customers.dao.mapper.ICustomerMapper;
import com.bbva.czic.dto.net.Customer;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

import org.springframework.stereotype.Component;

@Component(value = "customers-dao-impl")
public class CustomersDAOImpl implements CustomersDAO {

	private static final String FILTERERROR = null;
	
	@Resource(name="customerMapper")
	private ICustomerMapper customerMapper;

	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	@Autowired
	private TransaccionOznq transaccionOznq;
	@Autowired
	private TransaccionOzno transaccionOzno;

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvIntCustomers.class, "META-INF/spring/i18n/log/mensajesLog");

	
	public void setCustomerMapper(ICustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}
	@Override
	public List<DTOIntAccMovementsResume> getlistAccountsMovementsResume(
			DTOIntFilterCustomerResumes filter) throws BusinessServiceException {

		log.info("Into getlistAccountsMovementsResume...");
		log.info("getlistAccountsMovementsResume params:" + filter);

		DTOIntAccMovementsResume dtoIntAccountAccMovementsResume = null;
		List<DTOIntAccMovementsResume> accountMovementDtoList = null;

		try {
			FormatoOZECNQE0 formatoOZECNQE = new FormatoOZECNQE0();
			formatoOZECNQE.setIdusuar(filter.getCustomerId());
			formatoOZECNQE.setFechain(filter.getStartDate());
			formatoOZECNQE.setFechafi(filter.getEndDate());


			PeticionTransaccionOznq peticion = new PeticionTransaccionOznq();
			peticion.getCuerpo().getPartes().add(formatoOZECNQE);
			log.info("getlistAccountsMovementsResume formato entrada:" + peticion);
			RespuestaTransaccionOznq respuesta = transaccionOznq.invocar(peticion);
			log.info("getlistAccountsMovementsResume respuesta:" + respuesta);

			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null){
				throw new BusinessServiceException(EnumError.NO_DATA.getAlias());
			}

			List<CopySalida> outputCopies = respuesta.getCuerpo().getPartes(CopySalida.class);
			
			for (CopySalida outputCopy : outputCopies) {
				FormatoOZECNQS0 formatoSalida = outputCopy.getCopy(FormatoOZECNQS0.class);
				dtoIntAccountAccMovementsResume = customerMapper.map(formatoSalida);
				accountMovementDtoList.add(dtoIntAccountAccMovementsResume);
			}
		} catch (BusinessServiceException bse) {
			log.error("BusinessServiceException - Transaction error happened: " + bse.getMessage());
			throw bse;
		} catch (Exception e){
			e.printStackTrace();
		}
		return accountMovementDtoList;
	
	}

	@Override
	public List<DTOIntCardCharge> getlistCreCardCharges(
			DTOIntFilterCustomerResumes filter) throws BusinessServiceException {

		log.info("Into getlistCreCardCharges...");
		log.info("getlistCreCardCharges params:" + filter);

		DTOIntCardCharge dtoIntCardCharge = new DTOIntCardCharge();
		List<DTOIntCardCharge> cardChargetDtoList = new ArrayList<DTOIntCardCharge>();

		try {
			FormatoOZECNOE0 FormatoOZECNOE0 = new FormatoOZECNOE0();
			FormatoOZECNOE0.setNumprod(filter.getCustomerId());
			FormatoOZECNOE0.setFechain(filter.getStartDate());
			FormatoOZECNOE0.setFechafi(filter.getEndDate());


			PeticionTransaccionOzno peticion = new PeticionTransaccionOzno();

			peticion.getCuerpo().getPartes().add(FormatoOZECNOE0);
			log.info("getlistCreCardCharges formato de entrada:" + peticion);
			RespuestaTransaccionOzno respuesta = transaccionOzno.invocar(peticion);
			log.info("getlistCreCardCharges respuesta:" + respuesta);

			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null) {
				throw new BusinessServiceException(EnumError.NO_DATA.getAlias());
			}

			List<CopySalida> outputCopies = respuesta.getCuerpo().getPartes(CopySalida.class);
			
			for(CopySalida outputCopy :outputCopies){
				FormatoOZECNOS0 formatoSalida = outputCopy.getCopy(FormatoOZECNOS0.class);
				dtoIntCardCharge = customerMapper.map(formatoSalida);
				cardChargetDtoList.add(dtoIntCardCharge);
			}
			
		} catch (BusinessServiceException bse) {
			log.error("BusinessServiceException - Transaction error happened: " + bse.getMessage());
			throw bse;
		} catch (Exception e){
			e.printStackTrace();
		}
		return cardChargetDtoList;
	}
	
	@Override
	public DTOIntCustomer getCustomer(DTOIntFilterCustomerResumes filter)
			throws BusinessServiceException {
		log.info("Into getCustomer...");
		log.info("getCustomer params(customerId):" + filter.getCustomerId());
		
		
		return null;
	}

}
