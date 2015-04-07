package com.bbva.zic.customers.dao.model.oznw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNW</code>
 * 
 * @see PeticionTransaccionOznw
 * @see RespuestaTransaccionOznw
 */
@Component(value = "transaccionOznw")
public class TransaccionOznw implements InvocadorTransaccion<PeticionTransaccionOznw,RespuestaTransaccionOznw> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznw invocar(PeticionTransaccionOznw transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznw.class, RespuestaTransaccionOznw.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznw invocarCache(PeticionTransaccionOznw transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznw.class, RespuestaTransaccionOznw.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}