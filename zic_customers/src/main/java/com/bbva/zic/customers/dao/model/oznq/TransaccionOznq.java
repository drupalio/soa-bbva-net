package com.bbva.zic.customers.dao.model.oznq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNQ</code>
 * 
 * @see PeticionTransaccionOznq
 * @see RespuestaTransaccionOznq
 */
@Profile(value = "prod")
@Component(value = "transaccionOznq")
public class TransaccionOznq implements InvocadorTransaccion<PeticionTransaccionOznq,RespuestaTransaccionOznq> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznq invocar(PeticionTransaccionOznq transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznq.class, RespuestaTransaccionOznq.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznq invocarCache(PeticionTransaccionOznq transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznq.class, RespuestaTransaccionOznq.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}