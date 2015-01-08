package com.bbva.czic.accounts.dao.model.oznv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNV</code>
 * 
 * @see PeticionTransaccionOznv
 * @see RespuestaTransaccionOznv
 */
@Component
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
	
	@Override
	public void vaciarCache() {}	
}