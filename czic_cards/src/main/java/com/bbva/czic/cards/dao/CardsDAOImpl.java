package com.bbva.czic.cards.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
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

	private static I18nLog log = I18nLogFactory.getLogI18n(CardsDAOImpl.class,
			"META-INF/spring/i18n/log/mensajesLog");
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

		log.info("DAO - Llamado a la transaccion SMC : getCreditCardCharges SN Cards ");
		// Respuesta
	//	RespuestaTransaccionOzno respuesta = transaccionGetCardCharges
	//			.invocar(peticion);
		log.info("DAO - Se llama errorMappingHelpero para manejo de Exepciones SMC : getCreditCardCharges SN Cards ");
		// Verificamos si tiene excepcion la respuesta
	//	BusinessServiceException businessServiceException = errorMappingHelper
	//			.toBusinessServiceException(respuesta);

	//	if (businessServiceException != null) {
			log.info("DAO - Se encontro una Exepcion al llamar a la transaccion SMC : getCreditCardCharges SN Cards ");
	//		throw businessServiceException;
	//	}
	//	List<CopySalida> copiesSalida = respuesta.getCuerpo().getPartes(
	//			CopySalida.class);

		log.info("DAO - Se da inicio al mapeo de la lista que retorna en formatoHost a los DTO internos SMC : getCreditCardCharges SN Cards ");
	//	for (CopySalida copySalida : copiesSalida) {

	//		DTOIntCardCharge intCardCharge = new DTOIntCardCharge();

	//		FormatoOZECNOS0 formatoSalida = copySalida
	//				.getCopy(FormatoOZECNOS0.class);
	//		intCardCharge = CardsChargesMapper.mapToOuter(formatoSalida);
	//		listaCardCharge.add(intCardCharge);

//		}

		FormatoOZECNOS0 formatoSalida = new FormatoOZECNOS0();
		formatoSalida.setCategor("CATEGORY A");
		formatoSalida.setValcate(new BigDecimal("1000"));

		FormatoOZECNOS0 formatoSalida2 = new FormatoOZECNOS0();
		formatoSalida2.setCategor("CATEGORY B");
		formatoSalida2.setValcate(new BigDecimal("2000"));

		listaCardCharge.add(CardsChargesMapper.mapToOuter(formatoSalida));
		listaCardCharge.add(CardsChargesMapper.mapToOuter(formatoSalida2));

		log.info("DAO - Devuelve respuesta SMC : getCreditCardCharges SN Cards ");
		return listaCardCharge;
	}

}
