package com.bbva.czic.loan.dao.model.ozni.mock;

import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCSNI0;
import com.bbva.czic.loan.dao.model.ozni.PeticionTransaccionOzni;
import com.bbva.czic.loan.dao.model.ozni.RespuestaTransaccionOzni;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Invocador de la transacci&oacute;n <code>OZNI</code>
 * 
 * @see com.bbva.czic.loan.dao.model.ozni.PeticionTransaccionOzni
 * @see com.bbva.czic.loan.dao.model.ozni.RespuestaTransaccionOzni
 */
@Profile(value = "dev")
@Component(value = "transaccionOzni")
public class TransaccionOzniMock implements InvocadorTransaccion<PeticionTransaccionOzni,RespuestaTransaccionOzni> {
	
	@Autowired
	private ServicioTransacciones servicioTransacciones;
	
	@Override
	public RespuestaTransaccionOzni invocar(PeticionTransaccionOzni transaccion) throws ExcepcionTransaccion {
		RespuestaTransaccionOzni respuestaTransaccionOzni = new RespuestaTransaccionOzni();
		DataFactory dataFactory = new DataFactory();
		FormatoOZNCSNI0 formatoOZNCSNi0 = new FormatoOZNCSNI0();

		formatoOZNCSNi0.setFechaop(dataFactory.getBirthDate());
		formatoOZNCSNi0.setTipope("10");
		formatoOZNCSNi0.setNumeope("000000012");
		formatoOZNCSNi0.setBalance("10000");
		formatoOZNCSNi0.setValorop("0");
		formatoOZNCSNi0.setResto("GASTOS DE COBRANZA");
		formatoOZNCSNi0.setNumeext("2345");


		CopySalida copySalida = new CopySalida();
		copySalida.setCopy(formatoOZNCSNi0);

		respuestaTransaccionOzni.getCuerpo().getPartes().add(copySalida);

		FormatoOZNCSNI0 formatoOZNCSNi01 = new FormatoOZNCSNI0();

		formatoOZNCSNi01.setFechaop(dataFactory.getBirthDate());
		formatoOZNCSNi01.setTipope("10");
		formatoOZNCSNi01.setNumeope("000000012");
		formatoOZNCSNi01.setBalance("10000");
		formatoOZNCSNi01.setValorop("0");
		formatoOZNCSNi01.setResto("GASTOS DE COBRANZA");
		formatoOZNCSNi01.setNumeext("233444");

		CopySalida copySalida1 = new CopySalida();
		copySalida1.setCopy(formatoOZNCSNi01);


		respuestaTransaccionOzni.getCuerpo().getPartes().add(copySalida1);

		return respuestaTransaccionOzni;
	}
	
	@Override
	public RespuestaTransaccionOzni invocarCache(PeticionTransaccionOzni transaccion) throws ExcepcionTransaccion {
		return servicioTransacciones.invocar(PeticionTransaccionOzni.class, RespuestaTransaccionOzni.class, transaccion);
	}
	
	@Override
	public void vaciarCache() {}	
}