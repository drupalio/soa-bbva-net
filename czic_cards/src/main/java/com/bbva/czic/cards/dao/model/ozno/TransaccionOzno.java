package com.bbva.czic.cards.dao.model.ozno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;

/**
 * Invocador de la transacci&oacute;n <code>OZNO</code>
 * 
 * @see PeticionTransaccionOzno
 * @see RespuestaTransaccionOzno
 */
@Profile(value = "prod")
@Component(value = "transaccionOzno")
public class TransaccionOzno implements
		InvocadorTransaccion<PeticionTransaccionOzno, RespuestaTransaccionOzno> {

	@Autowired
	private ServicioTransacciones servicioTransacciones;

	@Override
	public RespuestaTransaccionOzno invocar(PeticionTransaccionOzno transaccion)
			throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzno.class,
				RespuestaTransaccionOzno.class, transaccion);
	}

	@Override
	public RespuestaTransaccionOzno invocarCache(
			PeticionTransaccionOzno transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzno.class,
				RespuestaTransaccionOzno.class, transaccion);
	}

	@Override
	public void vaciarCache() {
	}
}