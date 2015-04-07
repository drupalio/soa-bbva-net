package com.bbva.zic.accounts.dao.model.ozna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import com.bbva.zic.routine.commons.rm.utils.tx.Transaction;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;

/**
 * Invocador de la transacci&oacute;n <code>OZNA</code>
 * 
 * @see PeticionTransaccionOzna
 * @see RespuestaTransaccionOzna
 */
@Profile("prod")
@Transaction(value = "transaccionOzna")
public class TransaccionOzna implements InvocadorTransaccion<PeticionTransaccionOzna, RespuestaTransaccionOzna> {

	@Autowired
	private ServicioTransacciones servicioTransacciones;

	@Override
	public RespuestaTransaccionOzna invocar(PeticionTransaccionOzna transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones
				.invocar(PeticionTransaccionOzna.class, RespuestaTransaccionOzna.class, transaccion);
	}

	@Override
	public RespuestaTransaccionOzna invocarCache(PeticionTransaccionOzna transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones
				.invocar(PeticionTransaccionOzna.class, RespuestaTransaccionOzna.class, transaccion);
	}

	@Override
	public void vaciarCache() {
	}

	public void setServicioTransacciones(ServicioTransacciones servicioTransacciones) {
		this.servicioTransacciones = servicioTransacciones;
	}
}