package com.bbva.czic.customers.dao.model.oznp.mock;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPS0;
import com.bbva.czic.customers.dao.model.oznp.PeticionTransaccionOznp;
import com.bbva.czic.customers.dao.model.oznp.RespuestaTransaccionOznp;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

/**
 * Invocador de la transacci&oacute;n <code>OZNP</code>
 * 
 * @see PeticionTransaccionOznp
 * @see RespuestaTransaccionOznp
 */
@Component("TransaccionOznp")
@Profile("dev")
public class TransaccionOznpMock implements InvocadorTransaccion<PeticionTransaccionOznp,RespuestaTransaccionOznp> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOznp invocar(PeticionTransaccionOznp transaccion) throws ExcepcionTransaccion {
		final RespuestaTransaccionOznp respuesta = new RespuestaTransaccionOznp();

		try {
			respuesta.getCuerpo().getPartes().addAll(getCopyOZECNPS0List());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return respuesta;
	}

	@Override
	public RespuestaTransaccionOznp invocarCache(
			PeticionTransaccionOznp peticion) throws ExcepcionTransaccion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vaciarCache() {
		// TODO Auto-generated method stub
		
	}

	private List<CopySalida> getCopyOZECNPS0List() throws IOException {

		List<CopySalida> copies = new ArrayList<CopySalida>();

		List<FormatoOZECNPS0> formatoOZECNPS0s = new ObjectMapper().readValue(this.getClass().getClassLoader()
				.getResourceAsStream("mock/formatoOznp.json"), new TypeReference<List<FormatoOZECNPS0>>() {
		});

		for (FormatoOZECNPS0 formatoOZECNPS0 : formatoOZECNPS0s) {
			CopySalida copy = new CopySalida();
			copy.setCopy(formatoOZECNPS0s);
			copies.add(copy);
		}

		return copies;
	}
}