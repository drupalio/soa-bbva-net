package com.bbva.zic.accounts.dao.model.oznv;

import com.bbva.zic.routine.commons.rm.utils.tx.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNV</code>
 * 
 * @see PeticionTransaccionOznv
 * @see RespuestaTransaccionOznv
 */
@Profile("prod")
@Transaction(value = "transaccionOznv")
public class TransaccionOznv implements InvocadorTransaccion<PeticionTransaccionOznv,RespuestaTransaccionOznv> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznv invocar(PeticionTransaccionOznv transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznv.class, RespuestaTransaccionOznv.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznv invocarCache(PeticionTransaccionOznv transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznv.class, RespuestaTransaccionOznv.class, transaccion);
	}

	public void setServicioTransacciones(ServicioTransacciones servicioTransacciones) {
		this.servicioTransacciones = servicioTransacciones;
	}

	@Override
	public void vaciarCache() {}	
}