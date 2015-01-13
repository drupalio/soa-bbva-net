package com.bbva.czic.executives.dao;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.dao.model.oznr.FormatoOZECNRE0;
import com.bbva.czic.executives.dao.model.oznr.FormatoOZECNRS0;
import com.bbva.czic.executives.dao.model.oznr.PeticionTransaccionOznr;
import com.bbva.czic.executives.dao.model.oznr.RespuestaTransaccionOznr;
import com.bbva.czic.executives.dao.model.oznr.TransaccionOznr;
import com.bbva.czic.executives.facade.v01.ExecutivesMapper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.springframework.stereotype.Repository;

@Repository
public class ExecutivesDAOImpl implements ExecutivesDAO {

	@Autowired
	private TransaccionOznr transaccionGetExecutives;
	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	private static I18nLog log = I18nLogFactory.getLogI18n(
			ExecutivesDAOImpl.class, "META-INF/spring/i18n/log/mensajesLog");


	@Override
	public DTOIntExecutive getExecutive(String thirdPartyId)
			throws ExcepcionTransporte {

		PeticionTransaccionOznr peticion = new PeticionTransaccionOznr();
		FormatoOZECNRE0 formatoEntrada = new FormatoOZECNRE0();

		DTOIntExecutive dtoIntExecutive = new DTOIntExecutive();

		formatoEntrada.setIdusuar(thirdPartyId);
		peticion.getCuerpo().getPartes().add(formatoEntrada);



		log.info("DAO - Se invoca la transaccion de Host SMC : getExecutive SN Executives ");
		// Respuesta
		RespuestaTransaccionOznr respuesta = transaccionGetExecutives
				.invocar(peticion);

		log.info("DAO - Se llama al errorMappingHelper para manejo de exepciones SMC : getExecutive SN Executives ");
		BusinessServiceException businessServiceException = errorMappingHelper
				.toBusinessServiceException(respuesta);

		if (businessServiceException != null) {
			log.info("DAO - Transaccion retorna exepcion SMC : getExecutive SN Executives ");
			throw businessServiceException;
		}

		CopySalida copiesSalida = respuesta.getCuerpo().getParte(
				CopySalida.class);
		FormatoOZECNRS0 formatoSalida = copiesSalida
				.getCopy(FormatoOZECNRS0.class);
		log.info("DAO - Se mapea la respuesta para retornarla SMC : getExecutive SN Executives ");
		dtoIntExecutive = ExecutivesMapper.mapToOuter(formatoSalida);

		return dtoIntExecutive;
	}
}
