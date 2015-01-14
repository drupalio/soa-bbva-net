package com.bbva.czic.customers.dao.model.oznp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNP</code>
 * 
 * @see PeticionTransaccionOznp
 * @see RespuestaTransaccionOznp
 */
@Component
public class TransaccionOznp implements InvocadorTransaccion<PeticionTransaccionOznp,RespuestaTransaccionOznp> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznp invocar(PeticionTransaccionOznp transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznp.class, RespuestaTransaccionOznp.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznp invocarCache(PeticionTransaccionOznp transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznp.class, RespuestaTransaccionOznp.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}