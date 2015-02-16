package com.bbva.czic.customers.dao.model.oznq.mock;

import java.math.BigDecimal;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQS0;
import com.bbva.czic.customers.dao.model.oznq.PeticionTransaccionOznq;
import com.bbva.czic.customers.dao.model.oznq.RespuestaTransaccionOznq;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

@Profile(value = "dev")
@Component(value = "transaccionOznq")
public class TransaccionOznqMock implements InvocadorTransaccion<PeticionTransaccionOznq, RespuestaTransaccionOznq> {

	private static I18nLog log = I18nLogFactory.getLogI18n(TransaccionOznqMock.class,
			"META-INF/spring/i18n/log/mensajesLog");

	public TransaccionOznqMock() {
		log.info("CREANDO TransaccionOznqMock MOCK");
	}

	@Override
	public RespuestaTransaccionOznq invocar(PeticionTransaccionOznq peticion) throws ExcepcionTransaccion {

		RespuestaTransaccionOznq respuesta = new RespuestaTransaccionOznq();

		for (int i = 0; i < 5; i++) {

			FormatoOZECNQS0 formatoSalida = new FormatoOZECNQS0();

			formatoSalida.setMes("0" + i);
			formatoSalida.setSaltota("100000");
			formatoSalida.setValcarg("50000");
			formatoSalida.setValdepo("300000");

			CopySalida copySalida = new CopySalida();
			copySalida.setCopy(formatoSalida);
			respuesta.getCuerpo().getPartes().add(copySalida);

		}

		return respuesta;
	}

	@Override
	public RespuestaTransaccionOznq invocarCache(PeticionTransaccionOznq peticion) throws ExcepcionTransaccion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vaciarCache() {

	}

}
