package com.bbva.czic.executives.dao.model.oznr.mock;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.czic.executives.dao.model.oznr.FormatoOZECNRS0;
import com.bbva.czic.executives.dao.model.oznr.PeticionTransaccionOznr;
import com.bbva.czic.executives.dao.model.oznr.RespuestaTransaccionOznr;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

@Component(value = "transaccionOznr")
@Profile(value = "dev")
public class TransaccionOznrMock implements InvocadorTransaccion<PeticionTransaccionOznr, RespuestaTransaccionOznr> {

	@Override
	public RespuestaTransaccionOznr invocar(PeticionTransaccionOznr peticion) throws ExcepcionTransaccion {

		RespuestaTransaccionOznr resultado = new RespuestaTransaccionOznr();
		FormatoOZECNRS0 formato = new FormatoOZECNRS0();
		formato.setEmailej("Jhon00021@gmail.com");
		formato.setIdejecu("123456789");
		formato.setNomejec("Jhon Velasquez");
		formato.setOfiejec("Calle 93 - 15");
		formato.setTelejec("5253231");
		CopySalida copy = new CopySalida();
		copy.setCopy(formato);
		resultado.getCuerpo().getPartes().add(copy);
		// TODO Auto-generated method stub
		return resultado;
	}

	@Override
	public RespuestaTransaccionOznr invocarCache(PeticionTransaccionOznr peticion) throws ExcepcionTransaccion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vaciarCache() {
		// TODO Auto-generated method stub

	}

}
