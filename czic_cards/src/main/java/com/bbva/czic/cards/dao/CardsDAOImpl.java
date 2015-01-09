package com.bbva.czic.cards.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOE0;
import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOS0;
import com.bbva.czic.cards.dao.model.ozno.PeticionTransaccionOzno;
import com.bbva.czic.cards.dao.model.ozno.RespuestaTransaccionOzno;
import com.bbva.czic.cards.dao.model.ozno.TransaccionOzno;
import com.bbva.czic.cards.facade.v01.CardsChargesMapper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

@Repository
public class CardsDAOImpl implements CardsDAO {

	@Autowired
	private TransaccionOzno transaccionGetCardCharges;
	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	/**
	 * 
	 */
	@Override
	public List<DTOIntCardCharge> getCreditCardCharges(String id,
			Date startDate, Date endDate) throws ExcepcionTransporte {

		PeticionTransaccionOzno peticion = new PeticionTransaccionOzno();
		FormatoOZECNOE0 formatoEntrada = new FormatoOZECNOE0();
		List<DTOIntCardCharge> listaCardCharge = new ArrayList<DTOIntCardCharge>();

		// Se setean los datos de entrada
		formatoEntrada.setNumprod(id);
		formatoEntrada.setFechain(startDate);
		formatoEntrada.setFechafi(endDate);

		peticion.getCuerpo().getPartes().add(formatoEntrada);

		// Respuesta
		RespuestaTransaccionOzno respuesta = transaccionGetCardCharges
				.invocar(peticion);

		// Verificamos si tiene excepcion la respuesta
		BusinessServiceException businessServiceException = errorMappingHelper
				.toBusinessServiceException(respuesta);

		if (businessServiceException != null) {
			throw businessServiceException;
		}
		List<CopySalida> copiesSalida = respuesta.getCuerpo().getPartes(
				CopySalida.class);
		for (CopySalida copySalida : copiesSalida) {

			DTOIntCardCharge intCardCharge = new DTOIntCardCharge();

			FormatoOZECNOS0 formatoSalida = copySalida
					.getCopy(FormatoOZECNOS0.class);
			intCardCharge = CardsChargesMapper.mapToOuter(formatoSalida);
			listaCardCharge.add(intCardCharge);

		}
		return listaCardCharge;
	}

}
