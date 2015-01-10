package com.bbva.czic.cards.dao.model.ozno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNO</code>
 * 
 * @see PeticionTransaccionOzno
 * @see RespuestaTransaccionOzno
 */
@Component
public class TransaccionOzno implements InvocadorTransaccion<PeticionTransaccionOzno,RespuestaTransaccionOzno> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOzno invocar(PeticionTransaccionOzno transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzno.class, RespuestaTransaccionOzno.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOzno invocarCache(PeticionTransaccionOzno transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzno.class, RespuestaTransaccionOzno.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}