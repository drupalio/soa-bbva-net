package com.bbva.zic.loan.dao.model.oznk.mock;

import com.bbva.zic.loan.dao.model.oznk.FormatoOZNCSNK0;
import com.bbva.zic.loan.dao.model.oznk.PeticionTransaccionOznk;
import com.bbva.zic.loan.dao.model.oznk.RespuestaTransaccionOznk;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Invocador de la transacci&oacute;n <code>OZNK</code>
 * 
 * @see com.bbva.zic.loan.dao.model.oznk.PeticionTransaccionOznk
 * @see com.bbva.zic.loan.dao.model.oznk.RespuestaTransaccionOznk
 */
@Profile(value = "dev")
@Component(value = "transaccionOznk")
public class TransaccionOznkMock implements InvocadorTransaccion<PeticionTransaccionOznk,RespuestaTransaccionOznk> {

	@Override
	public RespuestaTransaccionOznk invocar(PeticionTransaccionOznk transaccion) throws ExcepcionTransaccion {

		RespuestaTransaccionOznk respuesta = new RespuestaTransaccionOznk();

		DataFactory dataFactory = new DataFactory();

		FormatoOZNCSNK0 formatoSalida = new FormatoOZNCSNK0();

		formatoSalida.setDescop("Descripcion");
		formatoSalida.setResto(dataFactory.getNumberText(5));
		formatoSalida.setNumemov(dataFactory.getNumberText(00000000));
		formatoSalida.setImporte("+00000000000");
		formatoSalida.setBalance("+00000000000");
		formatoSalida.setCoutaf(dataFactory.getNumberText(2));
		formatoSalida.setFechaop(new Date());

		formatoSalida.setFechaop(dataFactory.getDate(2014,05,23));

		CopySalida copySalida = new CopySalida();
		copySalida.setCopy(formatoSalida);
		respuesta.getCuerpo().getPartes().add(copySalida);

		return respuesta;
	}
	
	@Override
	public RespuestaTransaccionOznk invocarCache(PeticionTransaccionOznk transaccion) throws ExcepcionTransaccion {
		return null;
	}
	
	@Override
	public void vaciarCache() {}	
}