package com.bbva.czic.products.dao.model.ozn2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;

/**
 * Invocador de la transacci&oacute;n <code>OZN2</code>
 * 
 * @see PeticionTransaccionOzn2
 * @see RespuestaTransaccionOzn2
 */

@Profile(value = "prod")
@Component(value = "transaccionOzn2")
public class TransaccionOzn2 implements InvocadorTransaccion<PeticionTransaccionOzn2,RespuestaTransaccionOzn2> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOzn2 invocar(PeticionTransaccionOzn2 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzn2.class, RespuestaTransaccionOzn2.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOzn2 invocarCache(PeticionTransaccionOzn2 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzn2.class, RespuestaTransaccionOzn2.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}