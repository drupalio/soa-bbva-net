package com.bbva.czic.accounts.dao.model.ozns.mock;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Profile;

import com.bbva.czic.accounts.dao.model.ozns.FormatoOZECNSS0;
import com.bbva.czic.accounts.dao.model.ozns.PeticionTransaccionOzns;
import com.bbva.czic.accounts.dao.model.ozns.RespuestaTransaccionOzns;
import com.bbva.czic.dto.net.EnumCheckbookStatus;
import com.bbva.czic.routine.commons.rm.utils.tx.Transaction;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

/**
 * Invocador de la transacci&oacute;n <code>OZNS</code>
 * 
 * @see PeticionTransaccionOzns
 * @see RespuestaTransaccionOzns
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
		
		salida.setEstachq("H");
		salida.setFecemis(dataFactory.getDate(2014, 12, 12));
		salida.setFecentr(dataFactory.getDate(2014, 12, 12));
		salida.setPrimchq(dataFactory.getNumberText(10));
		salida.setUltichq(dataFactory.getNumberText(10));
		salida.setTotachq(dataFactory.getNumberText(3));
	
		copySalida.setCopy(salida);
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