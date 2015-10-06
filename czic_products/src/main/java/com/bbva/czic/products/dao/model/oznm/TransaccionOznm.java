package com.bbva.czic.products.dao.model.oznm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNM</code>
 * 
 * @see PeticionTransaccionOznm
 * @see RespuestaTransaccionOznm
 */
@Component(value = "transaccionOznm")
@Profile(value = "prod")
public class TransaccionOznm implements InvocadorTransaccion<PeticionTransaccionOznm,RespuestaTransaccionOznm> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznm invocar(PeticionTransaccionOznm transaccion) throws ExcepcionTransaccion {
		return getServicioTransacciones().invocar(PeticionTransaccionOznm.class, RespuestaTransaccionOznm.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznm invocarCache(PeticionTransaccionOznm transaccion) throws ExcepcionTransaccion {
		return getServicioTransacciones().invocar(PeticionTransaccionOznm.class, RespuestaTransaccionOznm.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}

	public ServicioTransacciones getServicioTransacciones() {
		return servicioTransacciones;
	}

	public void setServicioTransacciones(ServicioTransacciones servicioTransacciones) {
		this.servicioTransacciones = servicioTransacciones;
	}
}