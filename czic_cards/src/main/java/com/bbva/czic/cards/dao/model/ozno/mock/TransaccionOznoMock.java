package com.bbva.czic.cards.dao.model.ozno.mock;

import java.math.BigDecimal;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOS0;
import com.bbva.czic.cards.dao.model.ozno.PeticionTransaccionOzno;
import com.bbva.czic.cards.dao.model.ozno.RespuestaTransaccionOzno;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

@Profile(value = "dev")
@Component(value = "transaccionOzno")
public class TransaccionOznoMock implements InvocadorTransaccion<PeticionTransaccionOzno, RespuestaTransaccionOzno> {

	@Override
	public RespuestaTransaccionOzno invocar(PeticionTransaccionOzno peticion) throws ExcepcionTransaccion {

		RespuestaTransaccionOzno respuesta = new RespuestaTransaccionOzno();

		FormatoOZECNOS0 formatoSalida = new FormatoOZECNOS0();
		formatoSalida.setCategor("CHANNEL_SALES");
		formatoSalida.setValcate(new BigDecimal("1000"));
		CopySalida copySalida = new CopySalida();
		copySalida.setCopy(formatoSalida);
		respuesta.getCuerpo().getPartes().add(formatoSalida);

		FormatoOZECNOS0 formatoSalida2 = new FormatoOZECNOS0();
		formatoSalida2.setCategor("LEISURE");
		formatoSalida2.setValcate(new BigDecimal("2000"));
		CopySalida copySalida2 = new CopySalida();
		copySalida2.setCopy(formatoSalida2);
		respuesta.getCuerpo().getPartes().add(formatoSalida2);

		FormatoOZECNOS0 formatoSalida3 = new FormatoOZECNOS0();
		formatoSalida3.setCategor("OTHERS");
		formatoSalida3.setValcate(new BigDecimal("3000"));
		CopySalida copySalida3 = new CopySalida();
		copySalida3.setCopy(formatoSalida3);
		respuesta.getCuerpo().getPartes().add(formatoSalida3);

		FormatoOZECNOS0 formatoSalida4 = new FormatoOZECNOS0();
		formatoSalida4.setCategor("BASIC_COMMERCE");
		formatoSalida4.setValcate(new BigDecimal("4000"));
		CopySalida copySalida4 = new CopySalida();
		copySalida4.setCopy(formatoSalida4);
		respuesta.getCuerpo().getPartes().add(formatoSalida4);

		FormatoOZECNOS0 formatoSalida5 = new FormatoOZECNOS0();
		formatoSalida5.setCategor("GIFT_BOOK_DISC");
		formatoSalida5.setValcate(new BigDecimal("5000"));
		CopySalida copySalida5 = new CopySalida();
		copySalida5.setCopy(formatoSalida5);
		respuesta.getCuerpo().getPartes().add(formatoSalida5);

		FormatoOZECNOS0 formatoSalida6 = new FormatoOZECNOS0();
		formatoSalida6.setCategor("CLOTHING");
		formatoSalida6.setValcate(new BigDecimal("6000"));
		CopySalida copySalida6 = new CopySalida();
		copySalida6.setCopy(formatoSalida6);
		respuesta.getCuerpo().getPartes().add(formatoSalida6);

		return respuesta;
	}

	@Override
	public RespuestaTransaccionOzno invocarCache(PeticionTransaccionOzno peticion) throws ExcepcionTransaccion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vaciarCache() {
		// TODO Auto-generated method stub

	}

}
