package com.bbva.czic.accounts.dao.model.oznu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNU</code>
 * 
 * @see PeticionTransaccionOznu
 * @see RespuestaTransaccionOznu
 */
@Component
public class TransaccionOznu implements InvocadorTransaccion<PeticionTransaccionOznu,RespuestaTransaccionOznu> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznu invocar(PeticionTransaccionOznu transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznu.class, RespuestaTransaccionOznu.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznu invocarCache(PeticionTransaccionOznu transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznu.class, RespuestaTransaccionOznu.class, transaccion);
	}

	public void setServicioTransacciones(ServicioTransacciones servicioTransacciones) {
		this.servicioTransacciones = servicioTransacciones;
	}

	@Override
	public void vaciarCache() {}	
}