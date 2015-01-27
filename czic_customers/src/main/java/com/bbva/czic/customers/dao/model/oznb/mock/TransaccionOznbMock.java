package com.bbva.czic.customers.dao.model.oznb.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCSNB0;
import com.bbva.czic.customers.dao.model.oznb.PeticionTransaccionOznb;
import com.bbva.czic.customers.dao.model.oznb.RespuestaTransaccionOznb;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

/**
 * Invocador de la transacci&oacute;n <code>OZNB</code>
 * 
 * @see PeticionTransaccionOznb
 * @see RespuestaTransaccionOznb
 */
@Profile(value = "dev")
@Component(value = "transaccionOznb")
public class TransaccionOznbMock implements InvocadorTransaccion<PeticionTransaccionOznb,RespuestaTransaccionOznb> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznb invocar(PeticionTransaccionOznb transaccion) throws ExcepcionTransaccion {
		RespuestaTransaccionOznb respuesta = new RespuestaTransaccionOznb();
		FormatoOZNCSNB0 formatoSalida = new FormatoOZNCSNB0();
		CopySalida salida = new CopySalida();
		
		
		
		salida.setCopy(formatoSalida);
		respuesta.getCuerpo().getPartes().add(formatoSalida);
		return respuesta;
	}
	
	@Override
	public RespuestaTransaccionOznb invocarCache(PeticionTransaccionOznb transaccion) throws ExcepcionTransaccion {
		return null;
	}
	
	@Override
	public void vaciarCache() {}	
}