package com.bbva.zic.accounts.dao.model.ozns.mock;

import com.bbva.zic.accounts.dao.model.ozns.FormatoOZECNSS0;
import com.bbva.zic.accounts.dao.model.ozns.PeticionTransaccionOzns;
import com.bbva.zic.accounts.dao.model.ozns.RespuestaTransaccionOzns;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Profile;

import com.bbva.zic.dto.net.EnumCheckbookStatus;
import com.bbva.zic.routine.commons.rm.utils.tx.Transaction;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

/**
 * Invocador de la transacci&oacute;n <code>OZNS</code>
 * 
 * @see com.bbva.zic.accounts.dao.model.ozns.PeticionTransaccionOzns
 * @see com.bbva.zic.accounts.dao.model.ozns.RespuestaTransaccionOzns
 */
@Profile("dev")
@Transaction(value = "transaccionOzns")
public class TransaccionOznsMock implements InvocadorTransaccion<PeticionTransaccionOzns,RespuestaTransaccionOzns> {
	
	@Override
	public RespuestaTransaccionOzns invocar(PeticionTransaccionOzns transaccion) throws ExcepcionTransaccion {
		final RespuestaTransaccionOzns respuesta = new RespuestaTransaccionOzns();
		final FormatoOZECNSS0 salida = new FormatoOZECNSS0();
		final DataFactory dataFactory = new DataFactory();
		CopySalida copySalida = new CopySalida();


		salida.setEstachq(EnumCheckbookStatus.ANULADO.getCode());
		salida.setFecemis(dataFactory.getDate(2014, 12, 12));
		salida.setFecentr(dataFactory.getDate(2014, 12, 12));
		salida.setPrimchq(dataFactory.getNumberText(10));
		salida.setUltichq(dataFactory.getNumberText(10));
		salida.setTotachq(dataFactory.getNumberText(3));

		copySalida.setCopy(salida);
		respuesta.getCuerpo().getPartes().add(copySalida);

		final FormatoOZECNSS0 salida1 = new FormatoOZECNSS0();

		salida1.setEstachq(EnumCheckbookStatus.ANULADO.getCode());
		salida1.setFecemis(dataFactory.getDate(2014, 11, 15));
		salida1.setFecentr(dataFactory.getDate(2014, 10, 19));
		salida1.setPrimchq(dataFactory.getNumberText(10));
		salida1.setUltichq(dataFactory.getNumberText(10));
		salida1.setTotachq(dataFactory.getNumberText(3));

		CopySalida copySalida1 = new CopySalida();
		copySalida1.setCopy(salida);
		respuesta.getCuerpo().getPartes().add(copySalida);

		return respuesta;
	}
	
	@Override
	public RespuestaTransaccionOzns invocarCache(PeticionTransaccionOzns transaccion) throws ExcepcionTransaccion {
		return null;
	}
	
	@Override
	public void vaciarCache() {}	
}