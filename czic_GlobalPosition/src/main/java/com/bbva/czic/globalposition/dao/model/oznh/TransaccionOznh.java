package com.bbva.czic.globalposition.dao.model.oznh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Invocador de la transacci&oacute;n <code>OZNH</code>
 * 
 * @see PeticionTransaccionOznh
 * @see RespuestaTransaccionOznh
 */
@Component
public class TransaccionOznh implements InvocadorTransaccion<PeticionTransaccionOznh,RespuestaTransaccionOznh> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznh invocar(PeticionTransaccionOznh transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznh.class, RespuestaTransaccionOznh.class, transaccion);
	}
	
	@Override
	public RespuestaTransaccionOznh invocarCache(PeticionTransaccionOznh transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznh.class, RespuestaTransaccionOznh.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}