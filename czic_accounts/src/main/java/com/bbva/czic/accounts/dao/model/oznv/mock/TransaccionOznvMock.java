package com.bbva.czic.accounts.dao.model.oznv.mock;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.czic.accounts.dao.model.oznv.PeticionTransaccionOznv;
import com.bbva.czic.accounts.dao.model.oznv.RespuestaTransaccionOznv;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

@Profile(value = "dev")
@Component(value = "transaccionOznv")
public class TransaccionOznvMock implements InvocadorTransaccion<PeticionTransaccionOznv, RespuestaTransaccionOznv> {

	@Override
	public RespuestaTransaccionOznv invocar(PeticionTransaccionOznv transaccion) throws ExcepcionTransaccion {
		return null;
	}

	@Override
	public RespuestaTransaccionOznv invocarCache(PeticionTransaccionOznv transaccion) throws ExcepcionTransaccion {
		return null;
	}

	@Override
	public void vaciarCache() {
	}

}
