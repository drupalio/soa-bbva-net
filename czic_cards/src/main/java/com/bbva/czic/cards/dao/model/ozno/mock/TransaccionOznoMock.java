package com.bbva.czic.cards.dao.model.ozno.mock;

import java.math.BigDecimal;

import com.bbva.czic.dto.net.EnumCardChargeCategory;
import org.fluttercode.datafactory.impl.DataFactory;
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
		final DataFactory dataFactory = new DataFactory();

		String[] categories = {
				"OCIO                               ",
				"REGALOS, LIBROS, DISCOS            ",
				"COMERCIO BASICO                    ",
				"ROPA,CALZADO Y PERSONAL            ",
				"VARIOS                             ",
				"COMPRAS POR CANALES                "
		};

		for(String cat : categories){
			FormatoOZECNOS0 formatoSalida = new FormatoOZECNOS0();
			formatoSalida.setCategor(cat);
			formatoSalida.setValcate(new BigDecimal(dataFactory.getNumberBetween(100000,200000)));
			CopySalida copySalida = new CopySalida();
			copySalida.setCopy(formatoSalida);
			respuesta.getCuerpo().getPartes().add(copySalida);
		}

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
