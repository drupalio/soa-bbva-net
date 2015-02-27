package com.bbva.czic.loan.dao.model.oznk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNK</code>
 * 
 * @see PeticionTransaccionOznk
 * @see RespuestaTransaccionOznk
 */
@Component
public class TransaccionOznk implements InvocadorTransaccion<PeticionTransaccionOznk,RespuestaTransaccionOznk> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznk invocar(PeticionTransaccionOznk transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznk.class, RespuestaTransaccionOznk.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznk invocarCache(PeticionTransaccionOznk transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznk.class, RespuestaTransaccionOznk.class, transaccion);
	}

	public void setServicioTransacciones(ServicioTransacciones servicioTransacciones) {
		this.servicioTransacciones = servicioTransacciones;
	}

	@Override
	public void vaciarCache() {}	
}