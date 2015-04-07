package com.bbva.zic.customers.dao.model.oznz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNZ</code>
 * 
 * @see PeticionTransaccionOznz
 * @see RespuestaTransaccionOznz
 */
@Component
public class TransaccionOznz implements InvocadorTransaccion<PeticionTransaccionOznz,RespuestaTransaccionOznz> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;

	public void setServicioTransacciones(ServicioTransacciones servicioTransacciones) {
		this.servicioTransacciones = servicioTransacciones;
	}

	@Override

	public RespuestaTransaccionOznz invocar(PeticionTransaccionOznz transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznz.class, RespuestaTransaccionOznz.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznz invocarCache(PeticionTransaccionOznz transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznz.class, RespuestaTransaccionOznz.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}