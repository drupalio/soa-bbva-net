package com.bbva.czic.accounts.dao.model.oznv.mock;

import com.bbva.czic.accounts.dao.model.oznu.RespuestaTransaccionOznu;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVS0;
import com.bbva.czic.accounts.dao.model.oznv.PeticionTransaccionOznv;
import com.bbva.czic.accounts.dao.model.oznv.RespuestaTransaccionOznv;
import com.bbva.czic.routine.commons.rm.utils.tx.Transaction;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>OZNV</code>
 * 
 * @see com.bbva.czic.accounts.dao.model.oznv.PeticionTransaccionOznv
 * @see com.bbva.czic.accounts.dao.model.oznv.RespuestaTransaccionOznv
 */
@Profile("dev")
@Transaction(value = "transaccionOznv")
public class TransaccionOznvMock implements InvocadorTransaccion<PeticionTransaccionOznv,RespuestaTransaccionOznv> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznv invocar(PeticionTransaccionOznv transaccion) throws ExcepcionTransaccion {
		RespuestaTransaccionOznv respuesta = new RespuestaTransaccionOznv();
		FormatoOZECNVS0 formatoOZECNVS0 = new FormatoOZECNVS0();

		formatoOZECNVS0.setMes("12");
		formatoOZECNVS0.setSalddis("10000");

		CopySalida copySalida = new CopySalida();
		copySalida.setCopy(formatoOZECNVS0);
		respuesta.getCuerpo().getPartes().add(copySalida);

		return respuesta;
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