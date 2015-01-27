package com.bbva.czic.globalposition.dao.model.ozn1;

import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Invocador de la transacci&oacute;n <code>OZN1</code>
 * 
 * @see com.bbva.czic.globalposition.dao.model.ozn1.PeticionTransaccionOzn1
 * @see com.bbva.czic.globalposition.dao.model.ozn1.RespuestaTransaccionOzn1
 */
@Component(value = "transaccionOzn1")
@Profile("dev")
public class TransaccionOzn1Mock implements InvocadorTransaccion<PeticionTransaccionOzn1,RespuestaTransaccionOzn1> {

	@Autowired
	private ServicioTransacciones servicioTransacciones;

	@Override
	public RespuestaTransaccionOzn1 invocar(PeticionTransaccionOzn1 transaccion) throws ExcepcionTransaccion {
		RespuestaTransaccionOzn1 respuesta = new RespuestaTransaccionOzn1();

		FormatoOZECN1E0 formatoOZECN1E0 = (FormatoOZECN1E0) transaccion.getCuerpo().getPartes().get(0);
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

			try {
				respuesta.getCuerpo().getPartes().add(getCopyOZECN1S0List());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return respuesta;
	}
	
	@Override
	public RespuestaTransaccionOzn1 invocarCache(PeticionTransaccionOzn1 transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzn1.class, RespuestaTransaccionOzn1.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}

	private List<CopySalida> getCopyOZECN1S0List() throws IOException {

		List<CopySalida> copies = new ArrayList<CopySalida>();

		List<FormatoOZECN1S0> formatoOZECN1S0List = new ObjectMapper().readValue(
				this.getClass().getClassLoader().getResourceAsStream("mock/formatoOZN1S0.json"),
				new TypeReference<List<FormatoOZECN1S0>>() {
				}
		);

		for (FormatoOZECN1S0 formatoOZECN1S0 : formatoOZECN1S0List) {
			CopySalida copy = new CopySalida();
			copy.setCopy(formatoOZECN1S0);
			copies.add(copy);
		}

		return copies;
	}

	private List<CopySalida> getCopyOZECN1S1List() throws IOException {

		List<CopySalida> copies = new ArrayList<CopySalida>();

		List<FormatoOZECN1S0> formatoOZECN1S0List = new ObjectMapper().readValue(
				this.getClass().getClassLoader().getResourceAsStream("mock/formatoOZN1S1.json"),
				new TypeReference<List<FormatoOZECN1S0>>() {
				}
		);

		for (FormatoOZECN1S0 formatoOZECN1S0 : formatoOZECN1S0List) {
			CopySalida copy = new CopySalida();
			copy.setCopy(formatoOZECN1S0);
			copies.add(copy);
		}

		return copies;
	}

}