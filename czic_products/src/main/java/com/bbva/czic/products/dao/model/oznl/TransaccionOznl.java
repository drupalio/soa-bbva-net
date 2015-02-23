package com.bbva.czic.products.dao.model.oznl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNL</code>
 * 
 * @see PeticionTransaccionOznl
 * @see RespuestaTransaccionOznl
 */
@Component(value = "transaccionOznl")
@Profile(value="prod")
public class TransaccionOznl implements InvocadorTransaccion<PeticionTransaccionOznl,RespuestaTransaccionOznl> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznl invocar(PeticionTransaccionOznl transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznl.class, RespuestaTransaccionOznl.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznl invocarCache(PeticionTransaccionOznl transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznl.class, RespuestaTransaccionOznl.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}

	public void setServicioTransacciones(ServicioTransacciones servicioTransacciones) {
		this.servicioTransacciones = servicioTransacciones;
	}
}