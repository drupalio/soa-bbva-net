package com.bbva.czic.globalposition.dao.model.ozn1.mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.context.annotation.Profile;

import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1E0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S1;
import com.bbva.czic.globalposition.dao.model.ozn1.PeticionTransaccionOzn1;
import com.bbva.czic.globalposition.dao.model.ozn1.RespuestaTransaccionOzn1;
import com.bbva.czic.routine.commons.rm.utils.tx.Transaction;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

/**
 * Invocador de la transacci&oacute;n <code>OZN1</code>
 * 
 * @see com.bbva.czic.globalposition.dao.model.ozn1.PeticionTransaccionOzn1
 * @see com.bbva.czic.globalposition.dao.model.ozn1.RespuestaTransaccionOzn1
 */
@Profile("dev")
@Transaction(value = "transaccionOzn1")
public class TransaccionOzn1Mock implements InvocadorTransaccion<PeticionTransaccionOzn1, RespuestaTransaccionOzn1> {

	private static I18nLog log = I18nLogFactory.getLogI18n(TransaccionOzn1Mock.class,
			"META-INF/spring/i18n/log/mensajesLog");

	public TransaccionOzn1Mock() {
		log.info("Transaction OZNA Mocked");
	}

	@Override
	public RespuestaTransaccionOzn1 invocar(PeticionTransaccionOzn1 transaccion) throws ExcepcionTransaccion {
		RespuestaTransaccionOzn1 respuesta = new RespuestaTransaccionOzn1();

		FormatoOZECN1E0 formatoOZECN1E0 = (FormatoOZECN1E0)transaccion.getCuerpo().getPartes().get(0);
		if (formatoOZECN1E0.getTipprod() == null || "TC".equals(formatoOZECN1E0.getTipprod())) {

			try {
				respuesta.getCuerpo().getPartes().addAll(getCopyOZECN1S1List());
				respuesta.getCuerpo().getPartes().addAll(getCopyOZECN1S0List());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return respuesta;
	}

	@Override
	public RespuestaTransaccionOzn1 invocarCache(PeticionTransaccionOzn1 transaccion) throws ExcepcionTransaccion {
		return this.invocar(transaccion);
	}

	@Override
	public void vaciarCache() {
	}

	private List<CopySalida> getCopyOZECN1S0List() throws IOException {

		List<CopySalida> copies = new ArrayList<CopySalida>();

		List<FormatoOZECN1S0> formatoOZECN1S0List = new ObjectMapper().readValue(this.getClass().getClassLoader()
				.getResourceAsStream("mock/formatoOZN1S0.json"), new TypeReference<List<FormatoOZECN1S0>>() {
		});

		for (FormatoOZECN1S0 formatoOZECN1S0 : formatoOZECN1S0List) {
			CopySalida copy = new CopySalida();
			copy.setCopy(formatoOZECN1S0);
			copies.add(copy);
		}

		return copies;
	}

	private List<CopySalida> getCopyOZECN1S1List() throws IOException {

		List<CopySalida> copies = new ArrayList<CopySalida>();

		List<FormatoOZECN1S1> formatoOZECN1S1List = new ObjectMapper().readValue(this.getClass().getClassLoader()
				.getResourceAsStream("mock/formatoOZN1S1.json"), new TypeReference<List<FormatoOZECN1S1>>() {
		});

		for (FormatoOZECN1S1 formatoOZECN1S1 : formatoOZECN1S1List) {
			CopySalida copy = new CopySalida();
			copy.setCopy(formatoOZECN1S1);
			copies.add(copy);
		}

		return copies;
	}

}