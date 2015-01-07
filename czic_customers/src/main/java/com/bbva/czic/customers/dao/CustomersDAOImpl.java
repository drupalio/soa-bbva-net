package com.bbva.czic.customers.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
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
import com.bbva.czic.mapper.CustomerMapper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

public class CustomersDAOImpl implements CustomersDAO {

	private static final String FILTERERROR = null;
	@Resource(name = "CustomerMapper")
	private CustomerMapper customerMapper;
	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Autowired
	private ErrorMappingHelper errorMappingHelper;
	
	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvIntCustomers.class, "META-INF/spring/i18n/log/mensajesLog");

	@Override
	public List<DTOIntAccMovementsResume> getlistAccountsMovementsResume(
			String idUser, String fechain ,String fechafin)
			throws BusinessServiceException {

		DTOIntAccMovementsResume dtoIntAccountAccMovementsResume = new DTOIntAccMovementsResume();
		List<DTOIntAccMovementsResume> accountMovementDtoList = new ArrayList<DTOIntAccMovementsResume>();

		try {
			FormatoOZECNQE0 formatoOZECNQE = new FormatoOZECNQE0();
			
			PeticionTransaccionOznq peticion = new PeticionTransaccionOznq();
			
			/*	if (filter != null && !filter.contentEquals("null")) 
				log.info("A query string (filter) has been sended: " + filter);
				SearchCondition<DTOIntAccMovementsResume> sc;
				String fecha1 = null;
				String fecha2 = null;
				//String value = null;

			
				try {
					sc = new FiqlParser<DTOIntAccMovementsResume>(DTOIntAccMovementsResume.class).parse(filter);

					final List<PrimitiveStatement> splitDataFilter = bussinesToolKit.getDataFromFilter(sc);
					for (PrimitiveStatement st: splitDataFilter) {
						fecha1 = st.getProperty();
						fecha2 = st.getCondition().toString();
						//value = st.getValue().toString();
					}

					
				//	final String pattern = bussinesToolKit.matchesPatternFromFilter(SERVICENAME, filter);
			    //	if (pattern != null) {
				//		log.info("The pattern is: " + pattern);
				//	}
					
				} catch (SearchParseException e) {
					log.error("SearchParseException - The query string (filter) has failed: " + e);
					throw new BusinessServiceException(FILTERERROR, filter, e.getMessage()); 
				} */
			
			
			
			peticion.getCuerpo().getPartes().add(formatoOZECNQE);
			RespuestaTransaccionOznq respuesta = new TransaccionOznq()
					.invocar(peticion);

			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null) throw new BusinessServiceException("noDataCustomerListAccountsMovementsResume");
			List<CopySalida> outputCopies = respuesta.getCuerpo().getPartes(CopySalida.class);
			
			for (CopySalida outputCopy : outputCopies) {
				FormatoOZECNQS0 formatoSalida = outputCopy.getCopy(FormatoOZECNQS0.class);
				dtoIntAccountAccMovementsResume = customerMapper.map(formatoSalida, DTOIntAccMovementsResume.class);
				accountMovementDtoList.add(dtoIntAccountAccMovementsResume);
				
			}
			
			
		} catch (Exception e) {
		}
		
		return accountMovementDtoList;
	
		}

	@Override
	public List<DTOIntCardCharge> getlistCreCardCharges(String idUser,String fechain , String fechafi) throws BusinessServiceException {

		DTOIntCardCharge dtoIntCardCharge = new DTOIntCardCharge();
		List<DTOIntCardCharge> cardChargetDtoList = new ArrayList<DTOIntCardCharge>();

		try {
			FormatoOZECNOE0 FormatoOZECNOE0 = new FormatoOZECNOE0();
			FormatoOZECNOE0.setNumprod(idUser);

			PeticionTransaccionOzno peticion = new PeticionTransaccionOzno();
		/*	if (filter != null && !filter.contentEquals("null")) 
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

				
					//final String pattern = bussinesToolKit.matchesPatternFromFilter(SERVICENAME, filter);
					//if (pattern != null) {
				    //		log.info("The pattern is: " + pattern);
				//	}
				
				} catch (SearchParseException e) {
					log.error("SearchParseException - The query string (filter) has failed: " + e);
					throw new BusinessServiceException(FILTERERROR, filter, e.getMessage());
			
			
				}*/
			

			peticion.getCuerpo().getPartes().add(FormatoOZECNOE0);
			RespuestaTransaccionOzno respuesta = new TransaccionOzno()
					.invocar(peticion);
			
			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null) throw new BusinessServiceException("noDataListCreditCardsCharges");
			List<CopySalida> outputCopies = respuesta.getCuerpo().getPartes(CopySalida.class);
			//if (outputCopy != null) {
			
			for(CopySalida outputCopy :outputCopies){
			FormatoOZECNOS0 formatoSalida = outputCopy.getCopy(FormatoOZECNOS0.class);
			dtoIntCardCharge = customerMapper.map(formatoSalida, DTOIntCardCharge.class);
			cardChargetDtoList.add(dtoIntCardCharge);
				
				
			}

			//FormatoOZECNOS0 formatoSalida = outputCopy.getCopy(FormatoOZECNOS0.class);		
			
		} catch (Exception e) {
		}
		return cardChargetDtoList;
	}

}
