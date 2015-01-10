package com.bbva.czic.accounts.dao.model.ozna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNA</code>
 * 
 * @see PeticionTransaccionOzna
 * @see RespuestaTransaccionOzna
 */
@Component
public class TransaccionOzna implements InvocadorTransaccion<PeticionTransaccionOzna,RespuestaTransaccionOzna> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOzna invocar(PeticionTransaccionOzna transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzna.class, RespuestaTransaccionOzna.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOzna invocarCache(PeticionTransaccionOzna transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzna.class, RespuestaTransaccionOzna.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}