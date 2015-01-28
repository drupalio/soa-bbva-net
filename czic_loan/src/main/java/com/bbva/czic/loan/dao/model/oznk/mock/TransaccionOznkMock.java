package com.bbva.czic.loan.dao.model.oznk.mock;

import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCSNK0;
import com.bbva.czic.loan.dao.model.oznk.PeticionTransaccionOznk;
import com.bbva.czic.loan.dao.model.oznk.RespuestaTransaccionOznk;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Invocador de la transacci&oacute;n <code>OZNK</code>
 * 
 * @see com.bbva.czic.loan.dao.model.oznk.PeticionTransaccionOznk
 * @see com.bbva.czic.loan.dao.model.oznk.RespuestaTransaccionOznk
 */
@Profile(value = "dev")
@Component(value = "transaccionOznk")
public class TransaccionOznkMock implements InvocadorTransaccion<PeticionTransaccionOznk,RespuestaTransaccionOznk> {

	@Override
	public RespuestaTransaccionOznk invocar(PeticionTransaccionOznk transaccion) throws ExcepcionTransaccion {

		RespuestaTransaccionOznk respuesta = new RespuestaTransaccionOznk();

		FormatoOZNCSNK0 formatoSalida = new FormatoOZNCSNK0();

		formatoSalida.setDescop("Descripcion");
		formatoSalida.setResto("12345");
		formatoSalida.setNumemov("0000000");
		formatoSalida.setImporte("+00000000000");
		formatoSalida.setBalance("+00000000000");
		//formatoSalida.setCoutaf("0000");
		//formatoSalida.setCoutat("0000");
		formatoSalida.setEstado("Acti");
		formatoSalida.setFechaop(new Date());

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