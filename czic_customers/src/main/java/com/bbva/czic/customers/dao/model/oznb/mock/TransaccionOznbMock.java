package com.bbva.czic.customers.dao.model.oznb.mock;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCSNB0;
import com.bbva.czic.customers.dao.model.oznb.PeticionTransaccionOznb;
import com.bbva.czic.customers.dao.model.oznb.RespuestaTransaccionOznb;
import com.bbva.czic.dto.net.EnumDwelingType;
import com.bbva.czic.dto.net.EnumSegmentType;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

/**
 * Invocador de la transacci&oacute;n <code>OZNB</code>
 * 
 * @see PeticionTransaccionOznb
 * @see RespuestaTransaccionOznb
 */
@Profile(value = "dev")
@Component(value = "transaccionOznb")
public class TransaccionOznbMock implements InvocadorTransaccion<PeticionTransaccionOznb,RespuestaTransaccionOznb> {
	
	@Override
	public RespuestaTransaccionOznb invocar(PeticionTransaccionOznb transaccion) throws ExcepcionTransaccion {
		RespuestaTransaccionOznb respuesta = new RespuestaTransaccionOznb();
		FormatoOZNCSNB0 formatoSalida = new FormatoOZNCSNB0();
		final DataFactory dataFactory = new DataFactory();
		CopySalida salida = new CopySalida();
		
		formatoSalida.setNomclie(dataFactory.getBusinessName());
		formatoSalida.setNumclie(dataFactory.getNumberText(8));
		formatoSalida.setSegment(EnumSegmentType.OTRO.toString());
		formatoSalida.setCorreo(dataFactory.getEmailAddress());
		formatoSalida.setDescvia(dataFactory.getAddress());
		formatoSalida.setCiudvia(dataFactory.getCity());
		formatoSalida.setDepavia(dataFactory.getCity());
		formatoSalida.setPaisvia(dataFactory.getStreetName());
		formatoSalida.setEstrato(dataFactory.getNumberText(1));
		formatoSalida.setAnosvda(dataFactory.getNumberText(2));
		formatoSalida.setNropnas(dataFactory.getNumberText(2));
		formatoSalida.setTpovvda(EnumDwelingType.VALIDAR.toString());
		formatoSalida.setDescofi(dataFactory.getAddress());
		formatoSalida.setCiudofi(dataFactory.getCity());
		formatoSalida.setDepaofi(dataFactory.getCity());
		formatoSalida.setPaisofi(dataFactory.getStreetName());
		formatoSalida.setUltconx(dataFactory.getDate(2015, 12, 12).toString());
		
		salida.setCopy(formatoSalida);
		respuesta.getCuerpo().getPartes().add(salida);
		return respuesta;
	}
	
	@Override
	public RespuestaTransaccionOznb invocarCache(PeticionTransaccionOznb transaccion) throws ExcepcionTransaccion {
		return null;
	}
	
	@Override
	public void vaciarCache() {}	
}