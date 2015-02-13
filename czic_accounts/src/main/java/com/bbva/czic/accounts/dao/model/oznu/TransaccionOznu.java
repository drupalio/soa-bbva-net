package com.bbva.czic.accounts.dao.model.oznu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
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
@Profile(value = "prod")
@Component(value = "transaccionOznu")
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
	
	@Override
	public void vaciarCache() {}

	public void setServicioTransacciones(ServicioTransacciones servicioTransacciones) {
		this.servicioTransacciones = servicioTransacciones;
	}
}