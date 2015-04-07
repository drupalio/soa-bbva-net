package com.bbva.zic.accounts.dao.model.ozny;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNY</code>
 * 
 * @see PeticionTransaccionOzny
 * @see RespuestaTransaccionOzny
 */
@Component(value = "transaccionOzny")
@Profile(value = "prod")
public class TransaccionOzny implements InvocadorTransaccion<PeticionTransaccionOzny,RespuestaTransaccionOzny> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOzny invocar(PeticionTransaccionOzny transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzny.class, RespuestaTransaccionOzny.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOzny invocarCache(PeticionTransaccionOzny transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzny.class, RespuestaTransaccionOzny.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}

	public void setServicioTransacciones(ServicioTransacciones servicioTransacciones) {
		this.servicioTransacciones = servicioTransacciones;
	}
}