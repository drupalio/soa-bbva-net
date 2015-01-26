package com.bbva.czic.globalposition.dao.model.ozn1;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Invocador de la transacci&oacute;n <code>OZN1</code>
 * 
 * @see com.bbva.czic.globalposition.dao.model.ozn1.PeticionTransaccionOzn1
 * @see com.bbva.czic.globalposition.dao.model.ozn1.RespuestaTransaccionOzn1
 */
@Component
@Profile("dev")
public class TransaccionOzn1Mock implements InvocadorTransaccion<PeticionTransaccionOzn1,RespuestaTransaccionOzn1> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOzn1 invocar(PeticionTransaccionOzn1 transaccion) throws ExcepcionTransaccion {
		RespuestaTransaccionOzn1 respuesta = new RespuestaTransaccionOzn1();

		FormatoOZECN1E0 formatoOZECN1E0 = (FormatoOZECN1E0)transaccion.getCuerpo().getPartes().get(0);
		if (formatoOZECN1E0.getTipprod() == null || "TC".equals(formatoOZECN1E0.getTipprod())) {
			FormatoOZECN1S1 formatoOZECN1S1 = new FormatoOZECN1S1();
			CopySalida copy = new CopySalida();
			formatoOZECN1S1.setTipprod("AH");
			formatoOZECN1S1.setNumprod("00130443000200009469");
			formatoOZECN1S1.setSaltota("00000000000018400");
			formatoOZECN1S1.setSaldisp("00000000000018400");
			formatoOZECN1S1.setIndvisi("C");
			formatoOZECN1S1.setIndoper("");
			formatoOZECN1S1.setAlias("");
			formatoOZECN1S1.setNomprod("");
			formatoOZECN1S1.setFinstat("");
			formatoOZECN1S1.setNumtarj("");
			formatoOZECN1S1.setNumcont("");
			formatoOZECN1S1.setNumcelu("");
			respuesta.getCuerpo().getPartes().add(copy);

		} else {
			FormatoOZECN1S0 formatoOZECN1S0 = new FormatoOZECN1S0();

			formatoOZECN1S0.setTipprod("AH");
			formatoOZECN1S0.setNumprod("00130640000200129961");
			formatoOZECN1S0.setSaltota("00000000000363535");
			formatoOZECN1S0.setSaldisp("00000000000363535");
			formatoOZECN1S0.setSalcanj("00000000000000000");
			formatoOZECN1S0.setIndoper("B");
			formatoOZECN1S0.setIndoper("");
			formatoOZECN1S0.setAlias("");
			formatoOZECN1S0.setNomprod("");
			formatoOZECN1S0.setFinstat("");

			CopySalida copy = new CopySalida();
			copy.setCopy(formatoOZECN1S0);
			respuesta.getCuerpo().getPartes().add(copy);
		}

		return respuesta;
	}
	
	@Override
	public RespuestaTransaccionOzn1 invocarCache(PeticionTransaccionOzn1 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzn1.class, RespuestaTransaccionOzn1.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}