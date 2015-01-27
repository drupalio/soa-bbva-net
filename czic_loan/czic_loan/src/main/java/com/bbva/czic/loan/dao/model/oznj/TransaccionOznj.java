package com.bbva.czic.loan.dao.model.oznj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNJ</code>
 * 
 * @see PeticionTransaccionOznj
 * @see RespuestaTransaccionOznj
 */
@Component
public class TransaccionOznj implements InvocadorTransaccion<PeticionTransaccionOznj,RespuestaTransaccionOznj> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznj invocar(PeticionTransaccionOznj transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznj.class, RespuestaTransaccionOznj.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznj invocarCache(PeticionTransaccionOznj transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznj.class, RespuestaTransaccionOznj.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}