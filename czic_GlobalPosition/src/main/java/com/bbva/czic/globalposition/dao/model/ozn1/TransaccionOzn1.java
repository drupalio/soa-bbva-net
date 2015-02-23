package com.bbva.czic.globalposition.dao.model.ozn1;

import com.bbva.czic.routine.commons.rm.utils.tx.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZN1</code>
 * 
 * @see PeticionTransaccionOzn1
 * @see RespuestaTransaccionOzn1
 */
@Profile("prod")
@Transaction(value = "transaccionOzn1")
public class TransaccionOzn1 implements InvocadorTransaccion<PeticionTransaccionOzn1,RespuestaTransaccionOzn1> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOzn1 invocar(PeticionTransaccionOzn1 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzn1.class, RespuestaTransaccionOzn1.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOzn1 invocarCache(PeticionTransaccionOzn1 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzn1.class, RespuestaTransaccionOzn1.class, transaccion);
	}

	public void setServicioTransacciones(ServicioTransacciones servicioTransacciones) {
		this.servicioTransacciones = servicioTransacciones;
	}

	@Override
	public void vaciarCache() {}	
}