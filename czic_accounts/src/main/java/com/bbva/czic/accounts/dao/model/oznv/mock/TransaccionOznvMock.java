package com.bbva.czic.accounts.dao.model.oznv.mock;

import java.math.BigDecimal;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVS0;
import com.bbva.czic.accounts.dao.model.oznv.PeticionTransaccionOznv;
import com.bbva.czic.accounts.dao.model.oznv.RespuestaTransaccionOznv;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

/**
 * Created by Entelgy on 27/01/2015.
 */
@Component(value = "transaccionOznv")
@Profile(value = "dev")
public class TransaccionOznvMock implements InvocadorTransaccion<PeticionTransaccionOznv, RespuestaTransaccionOznv> {

	@Override
	public RespuestaTransaccionOznv invocar(PeticionTransaccionOznv peticion) throws ExcepcionTransaccion {

		RespuestaTransaccionOznv resultado = new RespuestaTransaccionOznv();

		for (int i = 2; i < 33; i++) {
			FormatoOZECNVS0 formatoSalida1 = new FormatoOZECNVS0();
			Integer value = Integer.valueOf(1000) * i;
			formatoSalida1.setSalddis(new BigDecimal(value.toString()));
			if (i < 10) {
				formatoSalida1.setMes("0" + i);
			} else {
				formatoSalida1.setMes("" + i);
			}

			CopySalida copySalida1 = new CopySalida();
			copySalida1.setCopy(formatoSalida1);
			resultado.getCuerpo().getPartes().add(copySalida1);

		}

		return resultado;
	}

	@Override
	public RespuestaTransaccionOznv invocarCache(PeticionTransaccionOznv peticion) throws ExcepcionTransaccion {
		return null;
	}

	@Override
	public void vaciarCache() {

	}

}
