package com.bbva.czic.executives.dao;

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

	@Override
	public DTOIntExecutive getExecutive(String thirdPartyId)
			throws ExcepcionTransporte {

		PeticionTransaccionOznr peticion = new PeticionTransaccionOznr();
		FormatoOZECNRE0 formatoEntrada = new FormatoOZECNRE0();

		DTOIntExecutive dtoIntExecutive = new DTOIntExecutive();

		formatoEntrada.setIdusuar(thirdPartyId);

		peticion.getCuerpo().getParte(FormatoOZECNRS0.class);

		// Respuesta
		RespuestaTransaccionOznr respuesta = transaccionGetExecutives
				.invocar(peticion);

		BusinessServiceException businessServiceException = errorMappingHelper
				.toBusinessServiceException(respuesta);

		if (businessServiceException != null) {
			throw businessServiceException;
		}

		CopySalida copiesSalida = respuesta.getCuerpo().getParte(
				CopySalida.class);
		FormatoOZECNRS0 formatoSalida = copiesSalida
				.getCopy(FormatoOZECNRS0.class);

		dtoIntExecutive = ExecutivesMapper.mapToOuter(formatoSalida);

		return dtoIntExecutive;
	}
}
