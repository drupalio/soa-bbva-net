package com.bbva.czic.customers.dao.model.oznb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNB</code>
 * 
 * @see PeticionTransaccionOznb
 * @see RespuestaTransaccionOznb
 */
@Profile(value = "prod")
@Component(value = "transaccionOznb")
public class TransaccionOznb implements InvocadorTransaccion<PeticionTransaccionOznb,RespuestaTransaccionOznb> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznb invocar(PeticionTransaccionOznb transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznb.class, RespuestaTransaccionOznb.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznb invocarCache(PeticionTransaccionOznb transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznb.class, RespuestaTransaccionOznb.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}