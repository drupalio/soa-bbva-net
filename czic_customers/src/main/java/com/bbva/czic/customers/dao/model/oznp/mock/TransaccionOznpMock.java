package com.bbva.czic.customers.dao.model.oznp.mock;

import java.math.BigDecimal;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPS0;
import com.bbva.czic.customers.dao.model.oznp.PeticionTransaccionOznp;
import com.bbva.czic.customers.dao.model.oznp.RespuestaTransaccionOznp;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

/**
 * Invocador de la transacci&oacute;n <code>OZNP</code>
 * 
 * @see PeticionTransaccionOznp
 * @see RespuestaTransaccionOznp
 */
@Component
public class TransaccionOznpMock implements InvocadorTransaccion<PeticionTransaccionOznp,RespuestaTransaccionOznp> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznp invocar(PeticionTransaccionOznp transaccion) throws ExcepcionTransaccion {
		RespuestaTransaccionOznp respuesta = new RespuestaTransaccionOznp();
		FormatoOZECNPS0 formatoSalida = new FormatoOZECNPS0();
		final DataFactory dataFactory = new DataFactory();
		CopySalida salida = new CopySalida();
		
		formatoSalida.setCategor(dataFactory.getBusinessName());
		formatoSalida.setValcate(BigDecimal.valueOf(Double.parseDouble(dataFactory.getNumberText(15))));
		
		salida.setCopy(formatoSalida);
		respuesta.getCuerpo().getPartes().add(salida);
		return respuesta;
	}

	@Override
	public RespuestaTransaccionOznp invocarCache(
			PeticionTransaccionOznp peticion) throws ExcepcionTransaccion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vaciarCache() {
		// TODO Auto-generated method stub
		
	}
}