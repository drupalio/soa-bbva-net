package com.bbva.czic.globalposition.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.globalposition.business.dto.DTOIntEnumFinancialStatusType;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1E0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S1;
import com.bbva.czic.globalposition.dao.model.ozn1.PeticionTransaccionOzn1;
import com.bbva.czic.globalposition.dao.model.ozn1.RespuestaTransaccionOzn1;
import com.bbva.czic.globalposition.dao.model.ozn1.TransaccionOzn1;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.springframework.stereotype.Component;

@Component
public class GlobalPositionDAOImpl implements GlobalPositionDAO {

	@Autowired
	private TransaccionOzn1 transaccion;

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	@Override
	public List<DTOIntProduct> getExtractGlobalBalance(String customerId) throws ExcepcionTransporte {

		PeticionTransaccionOzn1 peticion = new PeticionTransaccionOzn1();
		FormatoOZECN1E0 formatoEntrada = new FormatoOZECN1E0();
		// TODO Cuando se envien el tipo de producto, se debe realizar un IF para validar
		// 1. Si es PG completa, se coloca el tipo de salida 1 (No comunes)
		// 2. Si es un tipo de producto diferente a tarjetas se mapea a el tipo de salida 0 (comunes)
		formatoEntrada.setNumclie(customerId);
		peticion.getCuerpo().getPartes().add(formatoEntrada);

		try {
			RespuestaTransaccionOzn1 respuesta = transaccion.invocar(peticion);
			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);

			if (exception != null) throw exception;
			CopySalida outputCopy = respuesta.getCuerpo().getParte(CopySalida.class);
			if (outputCopy != null) {
				FormatoOZECN1S1 formatoSalida = outputCopy.getCopy(FormatoOZECN1S1.class);
				if (formatoSalida != null) {
					DTOIntProduct dtoOut;
					List<DTOIntProduct> outputList = new ArrayList<DTOIntProduct>();

					dtoOut = new DTOIntProduct();
					dtoOut.setAlias(formatoSalida.getAlias());
					dtoOut.setFinancialState(DTOIntEnumFinancialStatusType.valueOf(formatoSalida.getFinstat()));
				}
			}

		} catch (ExcepcionTransporte e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public void updateProductVisibility(String idProduct, Boolean visible) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProductOperability(String idProduct, Boolean operable) {

		PeticionTransaccionOzn1 peticion = new PeticionTransaccionOzn1();
		FormatoOZECN1E0 formatoEntrada = new FormatoOZECN1E0();

		formatoEntrada.setNumclie(idProduct);

		peticion.getCuerpo().getPartes().add(formatoEntrada);
		try {
			transaccion.invocar(peticion);
		} catch (Exception e) {
			e.getMessage();
		}

	}
	// TODO: method implementations

}
