package com.bbva.czic.executives.dao.model.oznr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNR</code>
 * 
 * @see PeticionTransaccionOznr
 * @see RespuestaTransaccionOznr
 */
@Component(value = "transaccionOznr")
@Profile(value="prod")
public class TransaccionOznr implements InvocadorTransaccion<PeticionTransaccionOznr,RespuestaTransaccionOznr> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznr invocar(PeticionTransaccionOznr transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznr.class, RespuestaTransaccionOznr.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznr invocarCache(PeticionTransaccionOznr transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznr.class, RespuestaTransaccionOznr.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}