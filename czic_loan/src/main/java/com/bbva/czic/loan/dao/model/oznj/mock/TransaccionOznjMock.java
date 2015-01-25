package com.bbva.czic.loan.dao.model.oznj.mock;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.czic.loan.dao.model.oznj.PeticionTransaccionOznj;
import com.bbva.czic.loan.dao.model.oznj.RespuestaTransaccionOznj;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

@Profile(value = "prev")
@Component
public class TransaccionOznjMock
		implements
			InvocadorTransaccion<PeticionTransaccionOznj, RespuestaTransaccionOznj> {

	private static I18nLog log = I18nLogFactory.getLogI18n(
			TransaccionOznjMock.class, "META-INF/spring/i18n/log/mensajesLog");

	public TransaccionOznjMock() {
		log.info("CREANDO TransaccionOznjMock MOCK");
	}

	@Override
	public RespuestaTransaccionOznj invocar(PeticionTransaccionOznj peticion)
			throws ExcepcionTransaccion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RespuestaTransaccionOznj invocarCache(
			PeticionTransaccionOznj peticion) throws ExcepcionTransaccion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vaciarCache() {
		// TODO Auto-generated method stub

	}

}
