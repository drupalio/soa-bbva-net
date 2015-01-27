package com.bbva.czic.loan.dao.model.oznj.mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.loan.dao.model.oznj.PeticionTransaccionOznj;
import com.bbva.czic.loan.dao.model.oznj.RespuestaTransaccionOznj;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

@Profile(value = "dev")
@Component(value = "transaccionOznj")
public class TransaccionOznjMock implements	InvocadorTransaccion<PeticionTransaccionOznj, RespuestaTransaccionOznj> {

	private static I18nLog log = I18nLogFactory.getLogI18n(
			TransaccionOznjMock.class, "META-INF/spring/i18n/log/mensajesLog");

	public TransaccionOznjMock() {
		log.info("CREANDO TransaccionOznjMock MOCK");
	}

	@Override
	public RespuestaTransaccionOznj invocar(PeticionTransaccionOznj peticion)
			throws ExcepcionTransaccion {

		RespuestaTransaccionOznj respuesta = new RespuestaTransaccionOznj();

		FormatoOZNCSNJ0 formatoSalida = new FormatoOZNCSNJ0();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fechaCa = "2017-08-12";
		String fechaCo = "2015-12-10";
		String fechaLi = "2015-12-31";

		try {
			formatoSalida.setFechaca(formatter.parse(fechaCa));
			formatoSalida.setFechaco(formatter.parse(fechaCo));
			formatoSalida.setFechali(formatter.parse(fechaLi));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		formatoSalida.setNumcont("00130073005054466407");
		formatoSalida.setCuotato("00");
		formatoSalida.setDesctar("CUPO ROTATIVO");
		formatoSalida.setEstadot("Activa");
		formatoSalida.setHonorar("+00000000000");
		formatoSalida.setMntosol("+00700000000");
		formatoSalida.setPagomin("+00576468208");
		formatoSalida.setSaldope("+00000000000");
		formatoSalida.setSaldoto("+00000000000");
		formatoSalida.setTipprod("QI");

		CopySalida copySalida = new CopySalida();
		copySalida.setCopy(formatoSalida);
		respuesta.getCuerpo().getPartes().add(copySalida);

		return respuesta;
	}
	@Override
	public RespuestaTransaccionOznj invocarCache(
			PeticionTransaccionOznj peticion) throws ExcepcionTransaccion {
		return null;
	}

	@Override
	public void vaciarCache() {
	}
}
