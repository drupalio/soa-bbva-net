package com.bbva.czic.accounts.dao.model.oznu.mock;

import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUS0;
import com.bbva.czic.accounts.dao.model.oznu.PeticionTransaccionOznu;
import com.bbva.czic.accounts.dao.model.oznu.RespuestaTransaccionOznu;
import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>OZNU</code>
 * 
 * @see com.bbva.czic.accounts.dao.model.oznu.PeticionTransaccionOznu
 * @see com.bbva.czic.accounts.dao.model.oznu.RespuestaTransaccionOznu
 */
@Profile(value = "dev")
@Component(value = "transaccionOznu")
public class TransaccionOznuMock implements InvocadorTransaccion<PeticionTransaccionOznu,RespuestaTransaccionOznu> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznu invocar(PeticionTransaccionOznu transaccion) throws ExcepcionTransaccion {
		RespuestaTransaccionOznu respuesta = new RespuestaTransaccionOznu();
		final DataFactory dataFactory = new DataFactory();

		for(EnumMonth month : EnumMonth.values()) {
			FormatoOZECNUS0 formatoSalida = new FormatoOZECNUS0();

			formatoSalida.setValcarg(dataFactory.getNumberText(5));
			formatoSalida.setValdepo(dataFactory.getNumberText(5));
			formatoSalida.setSaldtot(dataFactory.getNumberText(5));
			formatoSalida.setMes(month.getCode() + "15");

			CopySalida copySalida = new CopySalida();
			copySalida.setCopy(formatoSalida);
			respuesta.getCuerpo().getPartes().add(copySalida);
		}
		return respuesta;
	}
	
	@Override
	public RespuestaTransaccionOznu invocarCache(PeticionTransaccionOznu transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOznu.class, RespuestaTransaccionOznu.class, transaccion);
	}

	public void setServicioTransacciones(ServicioTransacciones servicioTransacciones) {
		this.servicioTransacciones = servicioTransacciones;
	}

	@Override
	public void vaciarCache() {}	
}