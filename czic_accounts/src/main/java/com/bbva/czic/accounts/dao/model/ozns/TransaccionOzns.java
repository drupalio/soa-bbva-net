package com.bbva.czic.checkbooks.dao.model.ozns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNS</code>
 * 
 * @see PeticionTransaccionOzns
 * @see RespuestaTransaccionOzns
 */
@Component
public class TransaccionOzns implements InvocadorTransaccion<PeticionTransaccionOzns,RespuestaTransaccionOzns> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOzns invocar(PeticionTransaccionOzns transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzns.class, RespuestaTransaccionOzns.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOzns invocarCache(PeticionTransaccionOzns transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzns.class, RespuestaTransaccionOzns.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}