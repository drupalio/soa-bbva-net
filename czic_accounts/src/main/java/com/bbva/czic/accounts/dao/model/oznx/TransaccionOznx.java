package com.bbva.czic.accounts.dao.model.oznx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNX</code>
 * 
 * @see PeticionTransaccionOznx
 * @see RespuestaTransaccionOznx
 */
@Component
public class TransaccionOznx implements InvocadorTransaccion<PeticionTransaccionOznx,RespuestaTransaccionOznx> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznx invocar(PeticionTransaccionOznx transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznx.class, RespuestaTransaccionOznx.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznx invocarCache(PeticionTransaccionOznx transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznx.class, RespuestaTransaccionOznx.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}