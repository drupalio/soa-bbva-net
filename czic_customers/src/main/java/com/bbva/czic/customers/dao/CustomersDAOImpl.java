package com.bbva.czic.customers.dao;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.business.dto.DTOIntFilterCustomerResumes;
import com.bbva.czic.customers.business.impl.SrvIntCustomers;
import com.bbva.czic.customers.dao.mapper.CustomerMapper;
import com.bbva.czic.customers.dao.mapper.ICustomerMapper;
import com.bbva.czic.customers.dao.model.oznb.*;
import com.bbva.czic.customers.dao.model.oznp.*;
import com.bbva.czic.customers.dao.model.oznq.*;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


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
	private TransaccionOznb transaccionOznb;
	@Autowired
	private TransaccionOznp transaccionOznp;

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
				throw exception;
			}

			List<CopySalida> outputCopies = respuesta.getCuerpo().getPartes(CopySalida.class);
			log.info("getlistAccountsMovementsResume return:" + outputCopies);
			if(!outputCopies.isEmpty()) {
				for (CopySalida outputCopy : outputCopies) {
					FormatoOZECNQS0 formatoSalida = outputCopy.getCopy(FormatoOZECNQS0.class);
					dtoIntAccountAccMovementsResume = customerMapper.map(formatoSalida);
					accountMovementDtoList.add(dtoIntAccountAccMovementsResume);
				}
			}else{
				throw  new BusinessServiceException(EnumError.NO_DATA.getAlias());
			}
		} catch (BusinessServiceException bse) {
			log.error("BusinessServiceException - Transaction error happened: " + bse.getMessage());
			throw bse;
		} catch (Exception e){
			e.printStackTrace();
		}
		log.info("getlistAccountsMovementsResume response: " + accountMovementDtoList);
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

			if(!outputCopies.isEmpty()) {
				for (CopySalida outputCopy : outputCopies) {
					FormatoOZECNPS0 formatoSalida = outputCopy.getCopy(FormatoOZECNPS0.class);
					dtoIntCardCharge = customerMapper.map(formatoSalida);
					cardChargetDtoList.add(dtoIntCardCharge);
				}
			}else{
				throw  new BusinessServiceException(EnumError.NO_DATA.getAlias());
			}
		} catch (BusinessServiceException bse) {
			log.error("BusinessServiceException - Transaction error happened: " + bse.getMessage());
			throw bse;
		} catch (Exception e){
			e.printStackTrace();
		}
		log.info("getlistCreCardCharges response: " + cardChargetDtoList);
		return cardChargetDtoList;
	}

	@Override
	public DTOIntCustomer getCustomer(DTOIntFilterCustomerResumes filter)
			throws BusinessServiceException {
		log.info("CustDAO: Into getCustomer...");
		log.info("CustDAO: getCustomer params(customerId):" + filter.getCustomerId());

		DTOIntCustomer dtoIntCustomer = new DTOIntCustomer();

		FormatoOZNCENB0 formato = new FormatoOZNCENB0();

		formato.setNumclie(filter.getCustomerId());

		PeticionTransaccionOznb peticion = new PeticionTransaccionOznb();

		peticion.getCuerpo().getPartes().add(formato);
		log.info("getCustomer formato entrada:" + peticion);
		RespuestaTransaccionOznb respuesta = transaccionOznb.invocar(peticion);
		log.info("getCustomer respuesta:" + respuesta);

		BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
		if (exception != null) {
			throw exception;
		}

		CopySalida outputCopies = respuesta.getCuerpo().getParte(CopySalida.class);

		FormatoOZNCSNB0 formatoSalida = outputCopies.getCopy(FormatoOZNCSNB0.class);

		if (formatoSalida == null){
			throw new BusinessServiceException(EnumError.NO_DATA.getAlias());
		}

		log.info("DAO - Se mapea la respuesta para retornarla SMC : getCustomer SN Customer ");
		dtoIntCustomer = CustomerMapper.mapToOuter(formatoSalida);

		return dtoIntCustomer;
	}

}
