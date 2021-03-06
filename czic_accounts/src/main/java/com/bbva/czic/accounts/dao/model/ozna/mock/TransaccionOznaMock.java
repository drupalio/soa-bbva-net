package com.bbva.czic.accounts.dao.model.ozna.mock;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Profile;

import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.accounts.dao.model.ozna.PeticionTransaccionOzna;
import com.bbva.czic.accounts.dao.model.ozna.RespuestaTransaccionOzna;
import com.bbva.czic.routine.commons.rm.utils.tx.Transaction;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

@Profile("dev")
@Transaction(value = "transaccionOzna")
public class TransaccionOznaMock implements InvocadorTransaccion<PeticionTransaccionOzna, RespuestaTransaccionOzna> {

	private static I18nLog log = I18nLogFactory.getLogI18n(TransaccionOznaMock.class,
			"META-INF/spring/i18n/log/mensajesLog");

	public TransaccionOznaMock() {
		log.info("Transaction OZNA Mocked");
	}

	@Override
	public RespuestaTransaccionOzna invocar(PeticionTransaccionOzna peticion) throws ExcepcionTransaccion {

		final RespuestaTransaccionOzna respuesta = new RespuestaTransaccionOzna();
		final FormatoOZNCSNA0 salida = new FormatoOZNCSNA0();
		final DataFactory dataFactory = new DataFactory();

		salida.setNomprod(dataFactory.getRandomText(50));
		salida.setNumprod(dataFactory.getNumberText(20));
		salida.setSaltota(dataFactory.getNumberText(6));
		salida.setSdcanje(dataFactory.getNumberText(6));
		salida.setSddispo(dataFactory.getNumberText(6));
		salida.setTipprod("AH");

		salida.setIdcheq0(dataFactory.getNumberText(10));
		salida.setIdcheq1("00000000000000000");
		salida.setIdcheq2(dataFactory.getNumberText(20));
		salida.setIdcheq3(dataFactory.getNumberText(20));
		salida.setIdcheq4(dataFactory.getNumberText(20));
		salida.setIdcheq5(dataFactory.getNumberText(20));
		salida.setIdcheq6(dataFactory.getNumberText(20));
		salida.setIdcheq7(dataFactory.getNumberText(20));
		salida.setIdcheq8(dataFactory.getNumberText(20));
		salida.setIdcheq9(dataFactory.getNumberText(20));

		// IMPORTANTE
		CopySalida copySalida = new CopySalida();
		copySalida.setCopy(salida);

		respuesta.getCuerpo().getPartes().add(copySalida);

		return respuesta;
	}

	@Override
	public RespuestaTransaccionOzna invocarCache(PeticionTransaccionOzna peticion) throws ExcepcionTransaccion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vaciarCache() {
		// TODO Auto-generated method stub¡
	}

}
