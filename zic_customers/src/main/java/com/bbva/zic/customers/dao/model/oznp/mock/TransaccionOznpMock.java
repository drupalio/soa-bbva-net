package com.bbva.zic.customers.dao.model.oznp.mock;

import com.bbva.zic.customers.dao.model.oznp.FormatoOZECNPS0;
import com.bbva.zic.customers.dao.model.oznp.PeticionTransaccionOznp;
import com.bbva.zic.customers.dao.model.oznp.RespuestaTransaccionOznp;
import com.bbva.zic.dto.net.EnumCardChargeCategory;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Invocador de la transacci&oacute;n <code>OZNP</code>
 * 
 * @see com.bbva.zic.customers.dao.model.oznp.PeticionTransaccionOznp
 * @see com.bbva.zic.customers.dao.model.oznp.RespuestaTransaccionOznp
 */
@Profile(value = "dev")
@Component(value = "transaccionOznp")
public class TransaccionOznpMock implements InvocadorTransaccion<PeticionTransaccionOznp,RespuestaTransaccionOznp> {

	@Override
	public RespuestaTransaccionOznp invocar(PeticionTransaccionOznp peticion) throws ExcepcionTransaccion {

		final RespuestaTransaccionOznp respuesta = new RespuestaTransaccionOznp();
		final DataFactory dataFactory = new DataFactory();

		for(EnumCardChargeCategory item : EnumCardChargeCategory.values()){
			FormatoOZECNPS0 formatoSalida = new FormatoOZECNPS0();
			formatoSalida.setCategor(item.getText());
			formatoSalida.setValcate(new BigDecimal(dataFactory.getNumberBetween(10000, 20000)));

			CopySalida salida = new CopySalida();
			salida.setCopy(formatoSalida);
			respuesta.getCuerpo().getPartes().add(salida);
		}
		return respuesta;
	}

	@Override
	public RespuestaTransaccionOznp invocarCache(PeticionTransaccionOznp peticion) throws ExcepcionTransaccion {
		return null;
	}

	@Override
	public void vaciarCache() {

	}
}