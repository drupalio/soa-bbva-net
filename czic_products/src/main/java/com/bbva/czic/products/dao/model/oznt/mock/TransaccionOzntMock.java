package com.bbva.czic.products.dao.model.oznt.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.products.dao.model.oznt.PeticionTransaccionOznt;
import com.bbva.czic.products.dao.model.oznt.RespuestaTransaccionOznt;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;

/**
 * Invocador de la transacci&oacute;n <code>OZNT</code>
 * 
 * @see PeticionTransaccionOznt
 * @see RespuestaTransaccionOznt
 */
@Component
public class TransaccionOzntMock implements InvocadorTransaccion<PeticionTransaccionOznt,RespuestaTransaccionOznt> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznt invocar(PeticionTransaccionOznt transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznt.class, RespuestaTransaccionOznt.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznt invocarCache(PeticionTransaccionOznt transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznt.class, RespuestaTransaccionOznt.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}