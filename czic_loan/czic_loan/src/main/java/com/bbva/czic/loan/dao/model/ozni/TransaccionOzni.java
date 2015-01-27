package com.bbva.czic.loan.dao.model.ozni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNI</code>
 * 
 * @see PeticionTransaccionOzni
 * @see RespuestaTransaccionOzni
 */
@Component
public class TransaccionOzni implements InvocadorTransaccion<PeticionTransaccionOzni,RespuestaTransaccionOzni> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOzni invocar(PeticionTransaccionOzni transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzni.class, RespuestaTransaccionOzni.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOzni invocarCache(PeticionTransaccionOzni transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzni.class, RespuestaTransaccionOzni.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}