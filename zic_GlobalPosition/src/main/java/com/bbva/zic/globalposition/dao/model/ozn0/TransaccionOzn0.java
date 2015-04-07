package com.bbva.zic.globalposition.dao.model.ozn0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZN0</code>
 * 
 * @see PeticionTransaccionOzn0
 * @see RespuestaTransaccionOzn0
 */
@Component
public class TransaccionOzn0 implements InvocadorTransaccion<PeticionTransaccionOzn0,RespuestaTransaccionOzn0> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOzn0 invocar(PeticionTransaccionOzn0 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzn0.class, RespuestaTransaccionOzn0.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOzn0 invocarCache(PeticionTransaccionOzn0 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzn0.class, RespuestaTransaccionOzn0.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}

	public void setServicioTransacciones(ServicioTransacciones servicioTransacciones) {
		this.servicioTransacciones = servicioTransacciones;
	}
}